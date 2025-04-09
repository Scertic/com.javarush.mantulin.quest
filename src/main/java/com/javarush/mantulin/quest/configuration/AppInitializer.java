package com.javarush.mantulin.quest.configuration;

import com.javarush.mantulin.quest.repository.AnswerRepository;
import com.javarush.mantulin.quest.repository.QuestRepository;
import com.javarush.mantulin.quest.repository.QuestionRepository;
import com.javarush.mantulin.quest.service.QuestService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
//        ServletContextListener.super.contextInitialized(sce);
        QuestRepository questRepo = new QuestRepository();
        QuestionRepository questionRepo = new QuestionRepository();
        AnswerRepository answerRepo = new AnswerRepository();
        QuestService questService = new QuestService(questRepo, questionRepo, answerRepo);

        sce.getServletContext().setAttribute("questService", questService);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
