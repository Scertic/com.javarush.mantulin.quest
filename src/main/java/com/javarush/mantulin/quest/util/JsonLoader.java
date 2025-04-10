package com.javarush.mantulin.quest.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.mantulin.quest.entity.Quest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
//TODO под вопросом
public class JsonLoader {
    public static <T> List<T> loadFromJson(String filename, Class<T> type) {
        try (InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filename)) {

            if (inputStream == null) {
                throw new RuntimeException("File not found: " + filename);
            }

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    inputStream,
                    mapper.getTypeFactory().constructCollectionType(List.class, type)
            );
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("Failed to load JSON: " + filename, e);
        }
    }
}
