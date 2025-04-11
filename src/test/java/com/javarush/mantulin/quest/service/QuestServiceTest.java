package com.javarush.mantulin.quest.service;

import com.javarush.mantulin.quest.entity.Answer;
import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.entity.Question;
import com.javarush.mantulin.quest.repository.AnswerRepository;
import com.javarush.mantulin.quest.repository.QuestRepository;
import com.javarush.mantulin.quest.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class QuestServiceTest {

    private QuestService questService;
    private QuestRepository questRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @BeforeEach
    void initQuestService() {
        questRepository = mock(QuestRepository.class);
        questionRepository = mock(QuestionRepository.class);
        answerRepository = mock(AnswerRepository.class);

        questService = new QuestService(
                questRepository,
                questionRepository,
                answerRepository
        );
    }

    @Test
    void getQuests() {
        when(questRepository.getAll()).thenReturn(List.of(mock(Quest.class)));
        assertEquals(1, questService.getQuests().size());
        verify(questRepository).getAll();
    }

    @Test
    void findById_ifIdExists() {
        Quest mockQuest = mock(Quest.class);

        when(questRepository.findById(1)).thenReturn(Optional.of(mockQuest));
        assertSame(mockQuest, questService.findById(1));
        verify(questRepository).findById(1);
    }

    @Test
    void findById_ifIdNotExists() {
        when(questRepository.findById(-1)).thenReturn(Optional.empty());
        assertNull(questService.findById(-1));
        verify(questRepository).findById(-1);
    }

    @Test
    void getInstance_shouldBuildFullQuestStructure() {
        Quest quest = new Quest();
        quest.setId(1);

        Question question = new Question();
        question.setId(10);
        question.setQuestId(1);

        Answer answer = new Answer();
        answer.setId(100);
        answer.setQuestionId(10);

        when(questRepository.findById(1)).thenReturn(Optional.of(quest));
        when(questionRepository.findByQuestId(1)).thenReturn(List.of(question));
        when(answerRepository.findByQuestionId(10)).thenReturn(List.of(answer));

        Quest result = questService.getInstance(1);

        assertNotNull(result);
        assertEquals(1, result.getId());

        List<Question> questions = result.getQuestions();
        assertNotNull(questions);
        assertEquals(1, questions.size());

        Question resultQuestion = questions.get(0);
        assertEquals(10, resultQuestion.getId());

        List<Answer> answers = resultQuestion.getAnswers();
        assertNotNull(answers);
        assertEquals(1, answers.size());
        assertEquals(100, answers.get(0).getId());

        verify(questRepository).findById(1);
        verify(questionRepository).findByQuestId(1);
        verify(answerRepository).findByQuestionId(10);
    }
}