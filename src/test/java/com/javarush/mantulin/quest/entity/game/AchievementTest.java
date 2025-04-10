package com.javarush.mantulin.quest.entity.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AchievementTest {

    @Test
    void getDescription_ShouldReturnCorrectDescription() {
        assertEquals("Выиграл: ", Achievement.WIN.getDescription());
        assertEquals("Проиграл: ", Achievement.LOOSE.getDescription());
        assertEquals("Быстрая смерть: ", Achievement.FAST_DEAD.getDescription());
    }

}