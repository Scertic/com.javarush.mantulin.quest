package com.javarush.mantulin.quest;

import com.javarush.mantulin.quest.entity.Answer;
import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.repository.AnswerRepository;
import com.javarush.mantulin.quest.repository.QuestRepository;
import com.javarush.mantulin.quest.repository.QuestionRepository;
import com.javarush.mantulin.quest.repository.Repository;
import com.javarush.mantulin.quest.service.QuestService;

public class Main {
    public static void main(String[] args) {
        QuestService service = new QuestService(new QuestRepository(),new QuestionRepository(), new AnswerRepository());
        Quest instance = service.getInstance(1);
        for (Answer answer : instance.getQuestions().get(0).getAnswers()) {
            System.out.println(answer.getNextQuestionId());
        }
    }
}
