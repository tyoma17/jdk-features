package com.tyoma17.lang.annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InheritedClassLevelAnnotationTest {

    @Test
    void test() {

        InheritedClassLevelAnnotation inheritedAnnotationOnCanis =
                Canis.class.getAnnotation(InheritedClassLevelAnnotation.class);
        assertNotNull(inheritedAnnotationOnCanis);

        InheritedClassLevelAnnotation inheritedAnnotationOnDog
                = Dog.class.getAnnotation(InheritedClassLevelAnnotation.class);
        assertNotNull(inheritedAnnotationOnDog);
    }
}
