package com.javarush.mantulin.quest.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonLoader {
    public static <T> List<T> loadFromJson(String filename, Class<T> type) {
        try (InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(filename)) {

            if (inputStream == null) {
                throw new RuntimeException("File not found: " + filename);
            }

            return new ObjectMapper()
                    .readValue(inputStream,
                            new ObjectMapper().getTypeFactory()
                                    .constructCollectionType(List.class, type));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + filename, e);
        }
    }
}
