package com.example.project.sa2.springboot.controller;

import com.example.project.sa2.springboot.model.Course;
import com.example.project.sa2.springboot.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facultySystem")
public class ProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    //     http://localhost:8080/facultySystem/addCourse
    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        course.setOperationType("post");
        producerService.sendMessage(course);
        LOGGER.info(String.format("Request of POST a new course is received successfully! -> %s", course.toString()));
        return ResponseEntity.ok("New course is added successfully to faculty website! " + course.toString());
    }

    //    http://localhost:8080/facultySystem/deleteCourse
    @DeleteMapping("/deleteCourse")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course){
        course.setOperationType("delete");
        producerService.sendMessage(course);
        LOGGER.info(String.format("Request of DELETE an course is received successfully! -> %s", course.toString()));
        return ResponseEntity.ok("An course is deleted successfully from faculty website! " + course.toString());
    }

    //   http://localhost:8080/facultySystem/updateCourse
    @PutMapping("/updateCourse")
    public ResponseEntity<String> updateCourse(@RequestBody Course course){
        course.setOperationType("update");
        producerService.sendMessage(course);
        LOGGER.info(String.format("Request of PUT an course is received successfully! -> %s", course.toString()));
        return ResponseEntity.ok("An course is updated successfully from faculty website! " + course.toString());
    }
}
