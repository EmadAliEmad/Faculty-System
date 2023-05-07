package com.example.project.sa2.springboot.services;

import com.example.project.sa2.springboot.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServices {

    private final String topicName = "${topic.name}";
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerServices.class);

    @Autowired
    private DatabaseServices databaseServices;

    public ConsumerServices(DatabaseServices databaseServices) {
        this.databaseServices = databaseServices;
    }


    @KafkaListener(topics = topicName, groupId = "coursesGroup")
    public void consumeCourse(Course course){

        if (course.getOperationType().equals("post")){
            databaseServices.insertCourse(course);
            LOGGER.info(String.format("New course is received successfully from the kafka topic! -> %s", course.toString()));

        } else if (course.getOperationType().equals("delete")) {
            databaseServices.deleteAnCourse(course.getId());
            LOGGER.info(String.format("Deleted course is received successfully from the kafka topic! -> %s", course.toString()));
        }else if (course.getOperationType().equals("update")) {
            databaseServices.updateAnCourse(course);
            LOGGER.info(String.format("Updated course is received successfully from the kafka topic! -> %s", course.toString()));
        }
    }
}
