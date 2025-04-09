package com.javarush.mantulin.quest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Question {
    private int id;
    private int questId;
    private String name;
    private String text;
    private String imagePath;
    @JsonIgnore
    private List<Answer> answers;

    public Question(int id, int questId, String text, String imagePath) {
        this.id = id;
        this.questId = questId;
        this.text = text;
        this.imagePath = imagePath;
    }
}
