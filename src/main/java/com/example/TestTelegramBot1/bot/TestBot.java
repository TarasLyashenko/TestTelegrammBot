package com.example.TestTelegramBot1.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TestBot extends TelegramLongPollingBot
{
    @Override
    public void onUpdateReceived(Update update)
    {

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
