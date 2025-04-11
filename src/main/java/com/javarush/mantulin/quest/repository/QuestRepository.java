package com.javarush.mantulin.quest.repository;

import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.util.JsonLoader;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class QuestRepository implements Repository<Quest> {
    private static final List<Quest> STORAGE = new CopyOnWriteArrayList<>();
    static {
        STORAGE.addAll(JsonLoader.loadFromJson("quests.json", Quest.class));
    }

    @Override
    public Optional<Quest> findById(int id) {
        return STORAGE.stream()
                .filter(q -> q.getId() == id)
                .findFirst();
    }

    @Override
    public List<Quest> getAll() {
        return Collections.unmodifiableList(STORAGE);
    }

}
