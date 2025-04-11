package com.javarush.mantulin.quest.repository;

import com.javarush.mantulin.quest.entity.Quest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class QuestRepositoryTest {

    Repository<Quest> questRepository;

    @Test
    void findById_shouldReturnOptional() {
        questRepository = new QuestRepository();
        assertEquals(Optional.class, questRepository.findById(10).getClass());
    }

    @Test
    void getAll_shouldReturnUnmodifiableList() {
        questRepository = new QuestRepository();
        List<Quest> all = questRepository.getAll();
        assertThrows(UnsupportedOperationException.class, ()->{all.add(100, mock(Quest.class));});
    }
}