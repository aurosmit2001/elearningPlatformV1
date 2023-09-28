package com.example.eLearningFinal.controllers;

import com.example.eLearningFinal.model.Lesson;
import com.example.eLearningFinal.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses/{courseId}/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<Lesson> getAllLessons(@PathVariable Long courseId){
        return lessonService.getAllLessons(courseId);
    }
    @GetMapping("/{lessonId}")
    public Lesson getLessonById(@PathVariable Long courseId, @PathVariable Long lessonId) {
        return lessonService.getLessonById(courseId, lessonId);
    }
    @PostMapping
    public Lesson createLesson(@PathVariable Long courseId, @RequestBody Lesson lesson) {
        return lessonService.createLesson(courseId, lesson);
    }
    @PutMapping("/{lessonId}")
    public Lesson updateLesson(
            @PathVariable Long courseId,
            @PathVariable Long lessonId,
            @RequestBody Lesson updatedLesson
    ) {
        return lessonService.updateLesson(courseId, lessonId, updatedLesson);
    }
    @DeleteMapping("/{lessonId}")
    public void deleteLesson(@PathVariable Long courseId, @PathVariable Long lessonId) {
        lessonService.deleteLesson(courseId, lessonId);
    }

}
