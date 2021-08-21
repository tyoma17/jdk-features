package com.tyoma17.lang.copy.deep.commons_lang3;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeepCopyViaCommonsLangTest {

    @Test
    void deepCopyIsNotModified_whenOriginalObjectIsModified() {

        Dog buddy = new Dog("Buddy", 3);
        Person artyom = new Person("Artyom", 26, buddy);
        Person deepCopy = SerializationUtils.clone(artyom);

        buddy.setName("Luna");

        assertEquals("Luna", artyom.getDog().getName());
        assertEquals("Buddy", deepCopy.getDog().getName());
    }

}