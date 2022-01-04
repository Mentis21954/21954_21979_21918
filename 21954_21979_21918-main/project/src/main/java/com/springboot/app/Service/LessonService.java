package com.springboot.app.Service;

import com.springboot.app.Repository.LessonRepository;
import com.springboot.app.Entity.Lesson;
import com.springboot.app.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository repoLesson ;
    private RequestRepository requestRepository;

    public List<Lesson> getAllLessons() {
        return repoLesson.findAll();
    }

    public void saveLesson(Lesson lesson) {
        this.repoLesson.save(lesson);
    }

    public List<Lesson> getStudentLesson(Integer id) {
        List<Lesson> lessons = getAllLessons();
        for(int i=0 ; i<lessons.size() ; i++) {
            if(!lessons.get(i).getRequests().getId().equals(id)) {
                lessons.remove(i);
            }
        }
        return lessons;
    }

    public void deleteRequest(Integer id) {
        List<Lesson> lessonList = repoLesson.findAll();
        for(int i= 0 ; i<lessonList.size(); i++) {
            if(lessonList.get(i).getRequests().getId().equals(id)) {
                int lessonid = lessonList.get(i).getRequests().getId();
                repoLesson.deleteById(lessonid);
            }
        }
        requestRepository.deleteById(Long.valueOf(id));
    }
}
