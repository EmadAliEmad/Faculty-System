package com.example.project.sa2.springboot.repository;

import com.example.project.sa2.springboot.entity.CourseDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<CourseDb, Integer> {
}
