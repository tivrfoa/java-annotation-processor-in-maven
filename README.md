# Test Using Java Annotation Processors in Maven



### Test with `mvn clean install`

Example output:

```log
[loading /modules/java.base/java/lang/annotation/Annotation.class]
Round 1:
        input files: {user.Hello}
        annotations: [processor.Complexity]
        last round: false
========================== process
========= processingEnv = javac ProcessingEnvironment
Processor processor.ComplexityProcessor matches [/processor.Complexity] and returns false.
Round 2:
        input files: {}
        annotations: []
        last round: true
========================== process
========= processingEnv = javac ProcessingEnvironment
[checking user.Hello]
```


### References:

[Code Generation in the Java Compiler: Annotation Processors Do the Hard Work](https://www.youtube.com/watch?v=xswPPwYPAFM)

[Pass Compiler Arguments](https://maven.apache.org/plugins/maven-compiler-plugin/examples/pass-compiler-arguments.html)

