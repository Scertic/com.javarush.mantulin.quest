package com.javarush.mantulin.quest.repository;

import com.javarush.mantulin.quest.entity.Question;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class QuestionRepositoryTest {

    QuestionRepository questionRepository;

    @Test
    void findById_shouldReturnOptional() {
        questionRepository = new QuestionRepositoryImpl();
        assertEquals(Optional.class, questionRepository.findById(10).getClass());
    }

    @Test
    void getAll_shouldReturnUnmodifiableList() {
        questionRepository = new QuestionRepositoryImpl();
        List<Question> all = questionRepository.getAll();
        assertThrows(UnsupportedOperationException.class, ()-> all.add(100, mock(Question.class)));
    }

    @Test
    void findByQuestId() {
        questionRepository = new QuestionRepositoryImpl();
        assertEquals(List.of().getClass(), questionRepository.findByQuestId(1000).getClass());
    }
}