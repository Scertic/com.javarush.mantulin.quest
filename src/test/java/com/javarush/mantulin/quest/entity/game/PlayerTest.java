package com.javarush.mantulin.quest.entity.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void initPlayer() {
        player = new Player();
        player.setId(1);
        player.setName("Player");
    }

    @Test
    void gettersAndSetters() {
        Player testPlayer = new Player();
        testPlayer.setId(1);
        testPlayer.setName("Player");
        assertEquals(player.getId(), testPlayer.getId());
        assertEquals(player.getName(), testPlayer.getName());
        assertTrue(testPlayer.getRewards().isEmpty());
    }

    @Test
    void put_shouldCalculateInteger() {
        player.put(Achievement.WIN);
        assertEquals(1, player.getRewards().get(Achievement.WIN));
        player.put(Achievement.WIN);
        assertEquals(2, player.getRewards().get(Achievement.WIN));

    }

}