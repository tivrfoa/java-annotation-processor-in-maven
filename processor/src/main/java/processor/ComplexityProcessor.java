package processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes("processor.Complexity")
public class ComplexityProcessor extends AbstractProcessor {
	
	

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		System.out.println("========================== process");
		
		System.out.println("========= processingEnv = " + processingEnv);
		
		processingEnv.getMessager().printMessage(Kind.NOTE, "Nice =)", null);
		
		return false;
	}

}
