package com.javarush.mantulin.quest.repository;

import com.javarush.mantulin.quest.entity.Answer;

import java.util.List;

public interface AnswerRepository extends Repository<Answer> {
    List<Answer> findByQuestionId(int questionId);
}
