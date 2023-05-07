package com.example.project.sa2.springboot.controller;

import com.example.project.sa2.springboot.entity.CourseDb;
import com.example.project.sa2.springboot.services.DatabaseServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facultySystem")
public class ConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private DatabaseServices databaseServices;

    public ConsumerController(DatabaseServices databaseServices) {
        this.databaseServices = databaseServices;
    }

//     http://localhost:8081/facultySystem/list
    @GetMapping("/list")
    public List<CourseDb> getAllCourses(){
        LOGGER.info(String.format("Request of GET all courses is received successfully!"));
        return databaseServices.selectAllCourses();
    }

    //     http://localhost:8081/facultySystem/course/ "any id exists in database"
    @GetMapping("/course/{id}")
    public CourseDb getAnCourse(@PathVariable("id") int id){
        LOGGER.info(String.format("Request of GET an course is received successfully!"));
        return databaseServices.selectOneCourse(id);
    }
}
