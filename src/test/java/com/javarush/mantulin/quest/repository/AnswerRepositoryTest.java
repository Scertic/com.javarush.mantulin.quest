package com.javarush.mantulin.quest.repository;

import com.javarush.mantulin.quest.entity.Answer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class AnswerRepositoryTest {

    AnswerRepository answerRepository;

    @Test
    void findById_shouldReturnOptional() {
        answerRepository = new AnswerRepositoryImpl();
        assertEquals(Optional.class, answerRepository.findById(10).getClass());
    }

    @Test
    void getAll_shouldReturnUnmodifiableList() {
        answerRepository = new AnswerRepositoryImpl();
        List<Answer> all = answerRepository.getAll();
        assertThrows(UnsupportedOperationException.class, ()-> all.add(100, mock(Answer.class)));
    }

    @Test
    void findByQuestId() {
        answerRepository = new AnswerRepositoryImpl();
        assertEquals(List.of().getClass(), answerRepository.findByQuestionId(1000).getClass());
    }
}