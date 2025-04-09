package com.javarush.mantulin.quest.entity.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
public class Player {
    private int id;
    private String name;
    private Map<Achievement, Integer> rewards = new HashMap<>();

    public void put(Achievement achievement) {
        rewards.merge(achievement, 1, Integer::sum);
    }
}
