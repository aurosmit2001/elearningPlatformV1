package com.example.eLearningFinal.services;

import com.example.eLearningFinal.model.Course;
import com.example.eLearningFinal.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public List<Course> getALLCourse() {
        return courseRepository.findAll();
    }


    public Course getCourseById(Long course_id) {
        Optional<Course> courseOptional = courseRepository.findById(course_id);
        return  courseOptional.orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }


    public Course updateCourse(Long course_id, Course updatedCourse) {
        Optional<Course> courseOptional = courseRepository.findById(course_id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            return courseRepository.save(course);
        } else {
            return null;
        }
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
