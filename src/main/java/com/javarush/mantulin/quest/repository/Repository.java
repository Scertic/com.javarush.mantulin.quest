package com.javarush.mantulin.quest.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(int id);
    List<T> getAll();
}
