package com.javarush.mantulin.quest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.entity.Question;
import com.javarush.mantulin.quest.util.JsonLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class QuestionRepositoryImpl implements QuestionRepository {
    private static final List<Question> STORAGE = new CopyOnWriteArrayList<>();
    static {
        STORAGE.addAll(JsonLoader.loadFromJson("questions.json", Question.class));
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

    @Override
    public List<Question> findByQuestId(int questId) {
        return STORAGE.stream()
                .filter(x->x.getQuestId() == questId)
                .toList();
    }
}
