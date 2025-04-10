package com.javarush.mantulin.quest.repository;

import com.javarush.mantulin.quest.entity.Question;

import java.util.List;

public interface QuestionRepository extends Repository<Question> {
    List<Question> findByQuestId(int questId);
}
