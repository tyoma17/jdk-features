package com.tyoma17.lang.copy.deep.gson;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeepCopyViaGsonTest {

    @Test
    void deepCopyIsNotModified_whenOriginalObjectIsModified() {

        Dog buddy = new Dog("Buddy", 3);
        Person artyom = new Person("Artyom", 26, buddy);

        Gson gson = new Gson();
        Person deepCopy = gson.fromJson(gson.toJson(artyom), Person.class);

        buddy.setName("Luna");

        assertEquals("Luna", artyom.getDog().getName());
        assertEquals("Buddy", deepCopy.getDog().getName());
    }
}