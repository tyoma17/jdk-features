package com.tyoma17.lang.copy.deep.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeepCopyViaJacksonTest {

    @Test
    void deepCopyIsNotModified_whenOriginalObjectIsModified() throws JsonProcessingException {

        Dog buddy = new Dog("Buddy", 3);
        Person artyom = new Person("Artyom", 26, buddy);

        ObjectMapper objectMapper = new ObjectMapper();
        Person deepCopy = objectMapper.readValue(objectMapper.writeValueAsString(artyom), Person.class);

        buddy.setName("Luna");

        assertEquals("Luna", artyom.getDog().getName());
        assertEquals("Buddy", deepCopy.getDog().getName());
    }

}