package com.springboot.app.Service;

import com.springboot.app.Repository.LessonRepository;
import com.springboot.app.Entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    private LessonRepository repoLesson ;

    public void saveLesson(Lesson lesson) {
        this.repoLesson.save(lesson);
    }
}
