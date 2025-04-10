package com.javarush.mantulin.quest.repository;

public class RepositoryExceptions extends RuntimeException{
    public RepositoryExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
