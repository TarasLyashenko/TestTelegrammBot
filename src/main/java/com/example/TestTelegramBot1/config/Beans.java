package com.example.TestTelegramBot1.config;

import com.example.TestTelegramBot1.bot.TestBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans
{
    @Bean
    public TestBot createTestBot()
    {
        return new TestBot("6386064861:AAFPIt9YRnGjKbmlTqwoJJj2sUO_j9WMtvQ");
    }
}
