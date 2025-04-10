package com.javarush.mantulin.quest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.mantulin.quest.entity.Answer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnswerRepositoryImpl implements AnswerRepository {
    private static final List<Answer> STORAGE = new CopyOnWriteArrayList<>();

    static {
        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("answers.json");
            if (inputStream != null) {
                List<Answer> questsFromJson = new ObjectMapper()
                        .readValue(inputStream, new TypeReference<>() {
                        });
                STORAGE.addAll(questsFromJson);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load quests.json", e);
        }
    }
    @Override
    public Optional<Answer> findById(int id) {
        return STORAGE.stream()
                .filter(q -> q.getId() == id)
                .findFirst();
    }

    @Override
    public List<Answer> getAll() {
        return Collections.unmodifiableList(STORAGE);
    }

    @Override
    public List<Answer> findByQuestionId(int questionId) {
        return STORAGE.stream()
                .filter(x->x.getQuestionId() == questionId)
                .toList();
    }
}
