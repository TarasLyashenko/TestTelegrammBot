package com.example.TestTelegramBot1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Lesson
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String topic;
    private int numberHours;

    public Lesson(String topic, int numberHours)
    {
        this.topic = topic;
        this.numberHours = numberHours;
    }
}
