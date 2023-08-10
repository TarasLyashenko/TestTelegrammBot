package com.example.TestTelegramBot1.bot;

import com.example.TestTelegramBot1.dao.LessonDao;
import com.example.TestTelegramBot1.service.LessonService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestBot extends TelegramLongPollingBot
{
    @Resource
    private LessonDao lessonDao;
    private final LessonService lessonService;

    @Autowired
    public TestBot(String botToken, LessonService lessonService)
    {
        super(botToken);
        this.lessonService = lessonService;
    }

    @Transactional
    @Override
    public void onUpdateReceived(Update update)
    {
        lessonService.addLesson(update);
    }

    @Override
    public String getBotUsername()
    {
        return "TestTelergam_bot";
    }
}
