package com.example.eLearningFinal.controllers;

import com.example.eLearningFinal.model.Course;
import com.example.eLearningFinal.model.User;
import com.example.eLearningFinal.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getALLCourse() {
        return courseService.getALLCourse();
    }
    @GetMapping("/{course_id}")
    public  Course getCourseById(@PathVariable Long course_id){
        return courseService.getCourseById(course_id);
    }
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }
    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Long course_id, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(course_id, updatedCourse);
    }
    @DeleteMapping("/{course_id}")
    public String deleteCourse(@PathVariable Long course_id) {
        courseService.deleteCourse(course_id);
        return "Course deleted successfully";
    }

}
