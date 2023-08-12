package com.example.TestTelegramBot1.dao;

import com.example.TestTelegramBot1.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDao extends CrudRepository<Lesson, Long>
{
    Lesson findByTopic(String topic);
    Lesson findByNumberHours(int numberHours);
}

