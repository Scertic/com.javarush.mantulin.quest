package com.javarush.mantulin.quest.configuration;

import com.javarush.mantulin.quest.service.QuestService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AppInitializerTest {

    @Test
    void contextInitialized() {
        ServletContextEvent sce = mock(ServletContextEvent.class);
        ServletContext servletContext = mock(ServletContext.class);
        when(sce.getServletContext()).thenReturn(servletContext);

        AppInitializer appInitializer = new AppInitializer();
        appInitializer.contextInitialized(sce);

        ArgumentCaptor<QuestService> questServiceCaptor = ArgumentCaptor.forClass(QuestService.class);

        verify(servletContext).setAttribute(eq("questService"), questServiceCaptor.capture());
        QuestService actualService = questServiceCaptor.getValue();
        assertNotNull(actualService);

    }
}