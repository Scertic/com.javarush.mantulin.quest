package com.javarush.mantulin.quest.controller;

import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.service.QuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class MainControllerTest {
    private MainController mainController;
    private QuestService questService;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private ServletContext servletContext;
    private RequestDispatcher requestDispatcher;
    private ServletConfig servletConfig;
    @BeforeEach
    void init() throws ServletException {
        questService = mock(QuestService.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        servletContext = mock(ServletContext.class);
        requestDispatcher = mock(RequestDispatcher.class);
        servletConfig = mock(ServletConfig.class);

        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getAttribute("questService")).thenReturn(questService);
        when(request.getSession()).thenReturn(session);
        when(servletContext.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

        mainController = new MainController();
        mainController.init(servletConfig);

    }

    @Test
    void initController() {
        assertNotNull(mainController);
        verify(servletContext).getAttribute("questService");
    }

    @Test
    void doGet_forwardSetQuests() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestURI()).thenReturn("/");
        when(questService.getQuests()).thenReturn(List.of());

        List<Quest> quests = questService.getQuests();
        mainController.doGet(request, response);

        verify(session).setAttribute("quests", quests);
        verify(session).setAttribute("loose", null);
        verify(session).setAttribute("win", null);
        verify(servletContext.getRequestDispatcher("/index.jsp")).forward(request, response);
    }

    @Test
    void doGet_redirectWhenThrows() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestURI()).thenReturn("/quest");
        when(request.getParameter("questId")).thenReturn("NaN");

        mainController.doGet(request, response);

        verify(response).sendRedirect("/quest?questId=1");
    }

    @Test
    void doGet_redirect() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestURI()).thenReturn("/quest");
        when(request.getParameter("questId")).thenReturn("2");
        Quest mockQuest = mock(Quest.class);
        when(questService.findById(2)).thenReturn(mockQuest);

        mainController.doGet(request, response);

        verify(session).setAttribute("questSimple", mockQuest);
        verify(response).sendRedirect("/");

    }

}