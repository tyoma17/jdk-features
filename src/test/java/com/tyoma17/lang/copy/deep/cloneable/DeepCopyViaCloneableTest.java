package com.tyoma17.lang.copy.deep.cloneable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeepCopyViaCloneableTest {

    @Test
    void deepCopyIsNotModified_whenOriginalObjectIsModified() throws CloneNotSupportedException {

        Dog buddy = new Dog("Buddy", 3);
        Person artyom = new Person("Artyom", 26, buddy);
        Person deepCopy = (Person) artyom.clone();

        buddy.setName("Luna");

        assertEquals("Luna", artyom.getDog().getName());
        assertEquals("Buddy", deepCopy.getDog().getName());
    }
}