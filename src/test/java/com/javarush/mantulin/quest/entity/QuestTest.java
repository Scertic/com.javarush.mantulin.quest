package com.javarush.mantulin.quest.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class QuestTest {
    Quest quest;
    @BeforeEach
    public void initQuest() {
        quest = new Quest();
        quest.setId(1);
        quest.setName("First");
        quest.setIntro("Intro text");
        Question question = mock(Question.class);
        quest.setQuestions(List.of(question));
    }

    @Test
    public void gettersAndSetters() {
        Quest questTest = new Quest();
        questTest.setId(1);
        questTest.setName("First");
        questTest.setIntro("Intro text");
        Question question = mock(Question.class);
        questTest.setQuestions(List.of(question));
        assertEquals(quest.getId(), questTest.getId());
        assertEquals(quest.getName(), questTest.getName());
        assertEquals(quest.getIntro(), questTest.getIntro());
        assertEquals(quest.getQuestions().size(), questTest.getQuestions().size());
    }

}