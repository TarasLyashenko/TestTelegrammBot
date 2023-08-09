package com.example.TestTelegramBot1;

import com.example.TestTelegramBot1.bot.TestBot;
import com.example.TestTelegramBot1.dao.LessonDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TestTelegramBot1Application implements CommandLineRunner
{
    @Resource
    private LessonDao lessonDao;
    private TestBot testBot;

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
        TestBot testBot = new TestBot("6386064861:AAFPIt9YRnGjKbmlTqwoJJj2sUO_j9WMtvQ");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(testBot);

    }
}
