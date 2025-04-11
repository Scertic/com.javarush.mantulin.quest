package com.javarush.mantulin.quest.controller;

import com.javarush.mantulin.quest.entity.Quest;
import com.javarush.mantulin.quest.service.QuestService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet({"", "/quest"})
public class MainController extends HttpServlet {
    private QuestService questService;

    @Override
    public void init() {
        this.questService = (QuestService) getServletContext().getAttribute("questService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String requestURI = req.getRequestURI();
        if ("/".equals(requestURI)) {
            List<Quest> quests = questService.getQuests();
            currentSession.setAttribute("quests", quests);
            currentSession.setAttribute("loose", null);
            currentSession.setAttribute("win", null);
            getServletContext().getRequestDispatcher("/index.jsp")
                    .forward(req, resp);
        }
        if ("/quest".equals(requestURI)) {
            try {
                int questId = Integer.parseInt(req.getParameter("questId"));
                Quest byId = questService.findById(questId);
                currentSession.setAttribute("questSimple", byId);
                resp.sendRedirect("/");
            } catch (Exception e) {
                resp.sendRedirect("/quest?questId=1");
            }

        }
    }

}
