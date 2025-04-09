package com.javarush.mantulin.quest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Quest {
    private int id;
    private String name;
    private String intro;
    @JsonIgnore
    private List<Question> questions;
}
