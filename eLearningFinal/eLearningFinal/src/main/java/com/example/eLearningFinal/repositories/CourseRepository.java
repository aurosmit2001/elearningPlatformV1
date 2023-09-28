package com.example.eLearningFinal.repositories;

import com.example.eLearningFinal.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
