package com.javarush.mantulin.quest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.mantulin.quest.entity.Quest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class QuestRepository implements Repository<Quest> {
    private static final List<Quest> STORAGE = new CopyOnWriteArrayList<>();

    static {
        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("quests.json");
            if (inputStream != null) {
                List<Quest> questsFromJson = new ObjectMapper()
                        .readValue(inputStream, new TypeReference<>() {
                        });
                STORAGE.addAll(questsFromJson);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load quests.json", e);
        }
    }

    @Override
    public Optional<Quest> findById(int id) {
        return STORAGE.stream()
                .filter(q -> q.getId() == id)
                .findFirst();
    }

    @Override
    public List<Quest> getAll() {
        return Collections.unmodifiableList(STORAGE);
    }

}
