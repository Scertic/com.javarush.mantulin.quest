package com.javarush.mantulin.quest.service;

import com.javarush.mantulin.quest.entity.Answer;
import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.entity.Question;
import com.javarush.mantulin.quest.repository.AnswerRepository;
import com.javarush.mantulin.quest.repository.QuestRepository;
import com.javarush.mantulin.quest.repository.QuestionRepository;

import java.util.List;

public class QuestService {
    private final QuestRepository questRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuestService(
            QuestRepository questRepository,
            QuestionRepository questionRepository,
            AnswerRepository answerRepository) {
        this.questRepository = questRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public List<Quest> getQuests() {
        return questRepository.getAll();
    }

    public Quest findById(int questId) {
        return questRepository.findById(questId).orElse(null);
    }

    public Quest getInstance(int questId) {
        Quest quest = questRepository.findById(questId).orElse(null);
        if (quest == null) {
            return null;
        }
        List<Question> questions = questionRepository.findByQuestId(questId);
        quest.setQuestions(questions);
        for (Question question : quest.getQuestions()) {
            List<Answer> answers = answerRepository.findByQuestionId(question.getId());
            question.setAnswers(answers);
        }
        return quest;
    }
}
