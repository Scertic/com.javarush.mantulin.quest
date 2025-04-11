package com.javarush.mantulin.quest.repository;

import com.javarush.mantulin.quest.entity.Answer;
import com.javarush.mantulin.quest.util.JsonLoader;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class AnswerRepositoryImpl implements AnswerRepository {
    private static final List<Answer> STORAGE = new CopyOnWriteArrayList<>();

    static {
        STORAGE.addAll(JsonLoader.loadFromJson("answers.json", Answer.class));
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
