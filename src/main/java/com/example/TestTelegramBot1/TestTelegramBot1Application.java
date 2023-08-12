package com.example.TestTelegramBot1;

import com.example.TestTelegramBot1.bot.TestBot;
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
        try
        {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(testBot);
        }
        catch (TelegramApiException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
