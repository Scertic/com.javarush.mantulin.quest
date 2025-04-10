package com.javarush.mantulin.quest.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class QuestionTest {
    Question question;
    Answer answer = mock(Answer.class);
    @BeforeEach
    public void initQuestion() {
        question = new Question();
        question.setId(1);
        question.setQuestId(1);
        question.setName("First");
        question.setText("Question text");
        question.setAnswers(List.of(answer));
    }

    @Test
    public void gettersAndSetters() {
        Question questionTest = new Question();
        questionTest.setId(1);
        questionTest.setQuestId(1);
        questionTest.setName("First");
        questionTest.setText("Question text");
        questionTest.setAnswers(List.of(answer));
        assertEquals(question.getId(), questionTest.getId());
        assertEquals(question.getQuestId(), questionTest.getQuestId());
        assertEquals(question.getName(), questionTest.getName());
        assertEquals(question.getText(), questionTest.getText());
        assertEquals(question.getAnswers().size(), questionTest.getAnswers().size());
    }
}