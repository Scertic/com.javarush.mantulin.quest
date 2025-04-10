package com.javarush.mantulin.quest.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.javarush.mantulin.quest.entity.Quest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonLoaderTest {
    @Test
    void loadFromJson_whenFileIsCorrect() {
        assertEquals(7, JsonLoader.loadFromJson("quests.json", Quest.class).size());
    }
    @Test
    void loadFromJson_throwAndMessageWhenFileIsIncorrect() {
        Throwable runtimeExceptionIncorrectFile = assertThrows(RuntimeException.class, () -> JsonLoader.loadFromJson("quests_incorrect.json", Quest.class));
        Throwable runtimeExceptionNullFile = assertThrows(RuntimeException.class, () -> JsonLoader.loadFromJson(null, Quest.class));
        Throwable runtimeExceptionNonExistentFile = assertThrows(RuntimeException.class, () -> JsonLoader.loadFromJson("Если такой файл существует, то не повезло, тест упадет", Quest.class));
        assertEquals("Failed to load JSON: quests_incorrect.json", runtimeExceptionIncorrectFile.getMessage());
        assertEquals("Failed to load JSON: null", runtimeExceptionNullFile.getMessage());
        assertEquals("File not found: Если такой файл существует, то не повезло, тест упадет", runtimeExceptionNonExistentFile.getMessage());
    }
}