package com.javarush.mantulin.quest.entity.game;

import lombok.Getter;

@Getter
public enum Achievement {

    WIN("Выиграл: "),
    LOOSE("Проиграл: "),
    FAST_DEAD("Быстрая смерть: ");
    private final String description;

    Achievement(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        System.out.println(Achievement.WIN.getDescription());
    }
}
