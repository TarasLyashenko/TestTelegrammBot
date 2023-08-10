package com.example.TestTelegramBot1.bot;

import com.example.TestTelegramBot1.dao.LessonDao;
import com.example.TestTelegramBot1.entity.Lesson;
import jakarta.annotation.Resource;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestBot extends TelegramLongPollingBot
{

    @Resource
    private LessonDao lessonDao;

    @Override
    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        if (message.getText().startsWith("ДобавитьЛекцию"))
        {
            String[] parts = message.getText().split(" ");
            if (parts.length == 3)
            {
                String topic = parts[1];
                int numberHours = Integer.parseInt(parts[2]);

                Lesson lesson = new Lesson(topic, numberHours);
                lessonDao.save(lesson);
            }
        }
    }

    @Override
    public String getBotUsername()
    {
        return "TestTelergam_bot";
    }

    public TestBot(String token)
    {
        super(token);
    }
}
