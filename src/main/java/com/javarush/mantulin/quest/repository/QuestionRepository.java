package com.javarush.mantulin.quest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class QuestionRepository implements Repository<Question> {
    private static final List<Question> STORAGE = new CopyOnWriteArrayList<>();/*{{
        add(new Question(1,1, "First question", ""));
        add(new Question(2,1, "Second question", ""));
        add(new Question(3,1, "Third question", ""));
        add(new Question(4,1, "Fourth question", ""));
    }};*/
    static {
        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("questions.json");
            if (inputStream != null) {
                List<Question> questsFromJson = new ObjectMapper()
                        .readValue(inputStream, new TypeReference<>() {
                        });
                STORAGE.addAll(questsFromJson);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load quests.json", e);
        }
    }
    @Override
    public Optional<Question> findById(int id) {
        return STORAGE.stream()
                .filter(q -> q.getId() == id)
                .findFirst();
    }

    @Override
    public List<Question> getAll() {
        return Collections.unmodifiableList(STORAGE);
    }

    public List<Question> findByQuestId(int questId) {
        return STORAGE.stream()
                .filter(x->x.getQuestId() == questId)
                .toList();
    }
}
