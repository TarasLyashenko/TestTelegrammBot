package com.example.TestTelegramBot1.service;

import com.example.TestTelegramBot1.entity.Lesson;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface LessonService
{
    public void saveLesson(Lesson lesson);

    public void addLesson(Update update);
}
