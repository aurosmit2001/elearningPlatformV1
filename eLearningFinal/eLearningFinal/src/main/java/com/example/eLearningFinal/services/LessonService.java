package com.example.eLearningFinal.services;

import com.example.eLearningFinal.model.Course;
import com.example.eLearningFinal.model.Lesson;
import com.example.eLearningFinal.repositories.CourseRepository;
import com.example.eLearningFinal.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;
    private CourseRepository courseRepository;


    public List<Lesson> getAllLessons(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElse(null);

        if (course == null) {
            return null;
        }

        return course.getLessons();

    }

    public Lesson getLessonById(Long courseId, Long lessonId) {
        Course course = courseRepository.findById(courseId)
                .orElse(null);

        if (course == null) {
            return null;
        }

        return lessonRepository.findById(lessonId)
                .orElse(null);
    }

    public Lesson createLesson(Long courseId, Lesson lesson) {
        Course course = courseRepository.findById(courseId)
                .orElse(null);

        if (course == null) {
            return null;
        }

        lesson.setCourse(course);
        return lessonRepository.save(lesson);
    }

    public Lesson updateLesson(Long courseId, Long lessonId, Lesson updatedLesson) {
        Course course = courseRepository.findById(courseId)
                .orElse(null);

        if (course == null) {
            return null;
        }

        return lessonRepository.findById(lessonId)
                .map(lesson -> {
                    lesson.setTitle(updatedLesson.getTitle());
                    lesson.setContent(updatedLesson.getContent());
                    lesson.setOrderInCourse(updatedLesson.getOrderInCourse());

                    return lessonRepository.save(lesson);
                })
                .orElse(null);
    }

    public void deleteLesson(Long courseId, Long lessonId) {
        Course course = courseRepository.findById(courseId)
                .orElse(null);

        if (course == null) {
            return;
        }

        Lesson lesson = lessonRepository.findById(lessonId)
                .orElse(null);

        if (lesson == null) {
            return;
        }

        course.getLessons().remove(lesson);
        lessonRepository.deleteById(lessonId);
        courseRepository.save(course);
    }

}
