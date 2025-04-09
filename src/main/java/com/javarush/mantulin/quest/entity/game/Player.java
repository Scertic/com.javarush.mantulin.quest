package com.javarush.mantulin.quest.entity.game;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Player {
    private int id;
    private String name;
    private Map<Achievement, Integer> rewards = new HashMap<>();

    public void put(Achievement achievement) {
        if (rewards.get(achievement) == null) {
            rewards.put(achievement, 1);
        } else {
            rewards.put(achievement, rewards.get(achievement)+1);
        }
    }
}
