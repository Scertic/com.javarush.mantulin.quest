package com.javarush.mantulin.quest.controller;

import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.entity.game.Achievement;
import com.javarush.mantulin.quest.entity.game.Player;
import com.javarush.mantulin.quest.service.QuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameController extends HttpServlet {
    private QuestService questService;

    @Override
    public void init() {
        this.questService = (QuestService) getServletContext().getAttribute("questService");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();

        Player player = (Player) currentSession.getAttribute("player");
        if (player == null) {
            player = new Player();
            player.setName(req.getParameter("playerName"));
            currentSession.setAttribute("player", player);
        }

        Quest quest = questService.getInstance(Integer.parseInt(req.getParameter("questId")));
        currentSession.setAttribute("questFull", quest);
        currentSession.setAttribute("questionId", 0);

        getServletContext().getRequestDispatcher("/view/game.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        if (req.getParameter("questionId") == null) {
            getServletContext().getRequestDispatcher("/view/game.jsp")
                    .forward(req, resp);
            return;
        }

        Player player = (Player) req.getSession().getAttribute("player");
        int questionId = Integer.parseInt(req.getParameter("questionId"))-1;
        if (questionId < 0) {
            if (questionId == -1) {
                currentSession.setAttribute("loose", 1);
                player.put(Achievement.LOOSE);
            } else {
                currentSession.setAttribute("win", 1);
                player.put(Achievement.WIN);
            }
            currentSession.setAttribute("player", player);
            getServletContext().getRequestDispatcher("/view/game.jsp")
                    .forward(req, resp);
        }
        currentSession.setAttribute("questionId", questionId);

        resp.sendRedirect("/game");

    }
}
