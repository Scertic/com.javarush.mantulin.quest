package com.javarush.mantulin.quest.controller;

import com.javarush.mantulin.quest.entity.game.Achievement;
import com.javarush.mantulin.quest.entity.game.Player;
import com.javarush.mantulin.quest.service.QuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class GameControllerTest {
    private GameController gameController;
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

        gameController = new GameController();
        gameController.init(servletConfig);

    }

    @Test
    void initController() {
        assertNotNull(gameController);
        verify(servletContext).getAttribute("questService");
    }

    @Test
    void doPost_forwardWithCreatePlayer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("player")).thenReturn(null);
        when(request.getParameter("playerName")).thenReturn("NAME");
        when(request.getParameter("questId")).thenReturn("1");

        gameController.doPost(request, response);

        ArgumentCaptor<Player> playerCaptor = ArgumentCaptor.forClass(Player.class);
        verify(session).setAttribute(eq("player"), playerCaptor.capture());
        Player createdPlayer = playerCaptor.getValue();

        assertEquals("NAME", createdPlayer.getName());
        verify(session).setAttribute("player", createdPlayer);
        verify(questService).getInstance(1);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void doPost_forwardWithExistingPlayer() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("player")).thenReturn(null);
        when(request.getParameter("playerName")).thenReturn("NAME");
        when(request.getParameter("questId")).thenReturn("1");

        gameController.doPost(request, response);

        ArgumentCaptor<Player> playerCaptor = ArgumentCaptor.forClass(Player.class);
        verify(session).setAttribute(eq("player"), playerCaptor.capture());
        Player createdPlayer = playerCaptor.getValue();

        assertEquals("NAME", createdPlayer.getName());
        verify(session).setAttribute("player", createdPlayer);
        verify(questService).getInstance(1);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void doGet_forwardWhenParamNull() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("questionId")).thenReturn(null);

        gameController.doGet(request, response);

        verify(servletContext.getRequestDispatcher("/view/game.jsp")).forward(request, response);
    }

    @ParameterizedTest
    @ValueSource(strings = {"WIN", "LOOSE"})
    void doGet_forwardWhenLooseOrWin(String param) throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        if (Achievement.valueOf(param) == Achievement.WIN) {
            when(request.getParameter("questionId")).thenReturn("-1");
        } else {
            when(request.getParameter("questionId")).thenReturn("0");
        }
        Player player = mock(Player.class);
        when(session.getAttribute("player")).thenReturn(player);

        gameController.doGet(request,response);

        if (Achievement.valueOf(param) == Achievement.WIN) {
            verify(session).setAttribute("win", 1);
        } else {
            verify(session).setAttribute("loose", 1);
        }

        verify(player).put(Achievement.valueOf(param));
        verify(session).setAttribute("player", player);
        verify(servletContext.getRequestDispatcher("/view/game.jsp")).forward(request, response);
    }

    @Test
    void doGet_redirect() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter("questionId")).thenReturn("1");

        gameController.doGet(request, response);

        verify(session).setAttribute("questionId",0);
        verify(response).sendRedirect("/game");
    }
}