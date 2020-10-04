package processor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import javax.tools.JavaFileObject;

@SupportedAnnotationTypes("processor.Complexity")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class ComplexityProcessor extends AbstractProcessor {
	
	

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("========================== process");
		
		System.out.println("========= processingEnv = " + processingEnv);
		
		processingEnv.getMessager().printMessage(Kind.NOTE, "Nice =)", null);
		
		BufferedWriter bw = null;
		
		try {
			for (Element e : roundEnv.getElementsAnnotatedWith(Complexity.class)) {
				if (e.getKind() == ElementKind.CLASS) {
					TypeElement classElement = (TypeElement) e;
					PackageElement packageElement = (PackageElement) classElement.getEnclosingElement();
					
					log(Kind.NOTE,
							"annotated class: " + classElement.getQualifiedName(), e);
					
					JavaFileObject jfo = processingEnv.getFiler().createSourceFile(
							classElement.getQualifiedName() + "BeanInfo");
					
					log(Kind.NOTE, "creating source file: " + jfo.toUri(), e);
					
					bw = new BufferedWriter(jfo.openWriter());
					
					writeTypeStart(bw, classElement, packageElement);
					
					bw.flush();
					bw.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	private void writeTypeStart(BufferedWriter bw, TypeElement classElement,
			PackageElement packageElement) throws IOException {
		bw.append("package ");
		bw.append(packageElement.getQualifiedName());
		bw.append(";");
		bw.newLine();
		bw.newLine();
		
		bw.append("public class ");
		bw.append(classElement.getSimpleName());
		bw.append("BeanInfo extends java.beans.SimpleBeanInfo { }");
		bw.newLine();
	}

	private void log(Kind note, String msg, Element e) {
		processingEnv.getMessager().printMessage(note, msg, e);
	}

}
