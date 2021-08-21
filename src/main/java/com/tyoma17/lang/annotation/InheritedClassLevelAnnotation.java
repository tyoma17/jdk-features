package com.tyoma17.lang.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
@Inherited // only causes annotations to be inherited from superclasses; annotations on implemented interfaces have no effect
public @interface InheritedClassLevelAnnotation {
}
