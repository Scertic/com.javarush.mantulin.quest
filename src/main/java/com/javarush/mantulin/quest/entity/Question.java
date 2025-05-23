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
    @JsonIgnore
    private List<Answer> answers;
}
