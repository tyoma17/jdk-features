package com.tyoma17.lang.copy.deep.copy_constructor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeepCopyViaConstructorTest {

    @Test
    void deepCopyIsNotModified_whenOriginalObjectIsModified() {
        
        Dog buddy = new Dog("Buddy", 3);
        Person artyom = new Person("Artyom", 26, buddy);
        Person deepCopy = new Person(artyom);

        buddy.setName("Luna");

        assertEquals("Luna", artyom.getDog().getName());
        assertEquals("Buddy", deepCopy.getDog().getName());
    }
}