package com.example.TestTelegramBot1.bot;

import com.example.TestTelegramBot1.service.LessonService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestBot extends TelegramLongPollingBot
{
    @Resource
    private LessonService lessonService;

    public TestBot(String token)
    {
        super(token);
    }

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
