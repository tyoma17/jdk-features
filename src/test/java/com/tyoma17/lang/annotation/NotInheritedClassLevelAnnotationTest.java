package com.tyoma17.lang.annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NotInheritedClassLevelAnnotationTest {

    @Test
    void test() {

        NotInheritedClassLevelAnnotation notInheritedAnnotationOnCanis =
                Canis.class.getAnnotation(NotInheritedClassLevelAnnotation.class);
        assertNotNull(notInheritedAnnotationOnCanis);

        NotInheritedClassLevelAnnotation notInheritedAnnotationOnDog
                = Dog.class.getAnnotation(NotInheritedClassLevelAnnotation.class);
        assertNull(notInheritedAnnotationOnDog);
    }
}
