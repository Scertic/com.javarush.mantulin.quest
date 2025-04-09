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

    public Answer(int id, String text, int questionId, int nextQuestionId) {
        this.id = id;
        this.text = text;
        this.questionId = questionId;
        this.nextQuestionId = nextQuestionId;
    }
}
