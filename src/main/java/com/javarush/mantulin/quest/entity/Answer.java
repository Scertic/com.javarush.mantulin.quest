package com.javarush.mantulin.quest.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Answer {
    private int id;
    private String text;
    private int questionId;
    private int nextQuestionId;
}
