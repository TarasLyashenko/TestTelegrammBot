package com.example.TestTelegramBot1;

import com.example.TestTelegramBot1.bot.TestBot;
import com.example.TestTelegramBot1.service.LessonService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TestTelegramBot1Application implements CommandLineRunner
{
    @Resource
    private LessonService lessonService;

    public static void main(String[] args)
    {
        SpringApplication.run(TestTelegramBot1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {

    }

    @PostConstruct
    public void registerBot()
    {

        TestBot testBot = new TestBot("6386064861:AAFPIt9YRnGjKbmlTqwoJJj2sUO_j9WMtvQ", lessonService);
        TelegramBotsApi telegramBotsApi = null;
        try
        {
            telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        }
        catch (TelegramApiException e)
        {
            throw new RuntimeException(e);
        }
        try
        {
            telegramBotsApi.registerBot(testBot);
        }
        catch (TelegramApiException e)
        {
            throw new RuntimeException(e);
        }

    }
}
