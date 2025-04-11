package com.javarush.mantulin.quest.configuration;

import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.repository.AnswerRepositoryImpl;
import com.javarush.mantulin.quest.repository.QuestRepository;
import com.javarush.mantulin.quest.repository.QuestionRepositoryImpl;
import com.javarush.mantulin.quest.repository.Repository;
import com.javarush.mantulin.quest.service.QuestService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Repository<Quest> questRepo = new QuestRepository();
        QuestionRepositoryImpl questionRepo = new QuestionRepositoryImpl();
        AnswerRepositoryImpl answerRepo = new AnswerRepositoryImpl();
        QuestService questService = new QuestService(questRepo, questionRepo, answerRepo);

        sce.getServletContext().setAttribute("questService", questService);

    }
}
