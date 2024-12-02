package com.SmartWorld.utility;




import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Method testMethod, Constructor testConstructor) {
	annotation.setRetryAnalyzer(RetryAnalyzer.class);
}
	
}
