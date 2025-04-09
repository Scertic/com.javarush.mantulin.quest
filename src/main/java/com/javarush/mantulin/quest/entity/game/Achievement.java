package com.javarush.mantulin.quest.entity.game;

public enum Achievement {

    WIN("Выиграл: "),
    LOOSE("Проиграл: "),
    FAST_DEAD("Быстрая смерть: ");
    private String description;

    Achievement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        System.out.println(Achievement.WIN.getDescription());
    }
}
