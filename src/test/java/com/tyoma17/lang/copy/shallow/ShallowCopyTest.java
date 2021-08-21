package com.tyoma17.lang.copy.shallow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class ShallowCopyTest {

    @Test
    void shallowCopyReferencesOtherObject() {

        Dog buddy = new Dog("Buddy", 3);
        Person artyom = new Person("Artyom", 26, buddy);

        Person shallowCopy = new Person(artyom.getName(), artyom.getAge(), artyom.getDog());

        System.out.println(artyom.hashCode());
        System.out.println(shallowCopy.hashCode());

        assertNotSame(shallowCopy, artyom);
    }

    @Test
    void shallowCopyIsModified_whenOriginalObjectIsModified() {

        Dog buddy = new Dog("Buddy", 3);
        Person artyom = new Person("Artyom", 26, buddy);
        Person shallowCopy = new Person(artyom.getName(), artyom.getAge(), artyom.getDog());

        buddy.setName("Luna");
        assertEquals("Luna", shallowCopy.getDog().getName()); // Dog is not immutable
    }
}