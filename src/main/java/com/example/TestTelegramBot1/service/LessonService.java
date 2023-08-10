package com.example.TestTelegramBot1.service;

import com.example.TestTelegramBot1.dao.LessonDao;
import com.example.TestTelegramBot1.entity.Lesson;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Transactional
@Service
public class LessonService
{
    @Resource
    private final LessonDao lessonDao;

    @Autowired
    public LessonService(LessonDao lessonDao)
    {
        this.lessonDao = lessonDao;
    }

    public void saveLesson(Lesson lesson)
    {
        lessonDao.save(lesson);
    }

    public void addLesson(Update update)
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
                saveLesson(lesson);
            }
        }
    }
}
