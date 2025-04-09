package com.javarush.mantulin.quest.entity.game;

import lombok.Data;

import java.util.Map;

@Data
public class Player {
    private int id;
    private String name;
    private Map<String, String> rewards;
}
