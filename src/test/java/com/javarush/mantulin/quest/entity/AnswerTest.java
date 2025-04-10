package com.javarush.mantulin.quest.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    Answer answer;
    @BeforeEach
    void initAnswer() {
        answer = new Answer();
        answer.setId(1);
        answer.setText("Answer text");
        answer.setQuestionId(1);
        answer.setNextQuestionId(2);
    }

    @Test
    void gettersAndSetters() {
        Answer answerTest = new Answer();
        answerTest.setId(1);
        answerTest.setText("Answer text");
        answerTest.setQuestionId(1);
        answerTest.setNextQuestionId(2);
        assertEquals(answer.getId(), answerTest.getId());
        assertEquals(answer.getText(), answerTest.getText());
        assertEquals(answer.getQuestionId(), answerTest.getQuestionId());
        assertEquals(answer.getNextQuestionId(), answerTest.getNextQuestionId());
    }
}