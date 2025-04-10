package com.javarush.mantulin.quest;

import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.util.JsonLoader;

public class Main {
    public static void main(String[] args) {
        JsonLoader.loadFromJson("Если такой файл существует, то не повезло, тест упадет", Quest.class);
    }
}
