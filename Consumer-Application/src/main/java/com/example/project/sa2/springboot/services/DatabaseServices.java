package com.example.project.sa2.springboot.services;

import com.example.project.sa2.springboot.entity.CourseDb;
import com.example.project.sa2.springboot.model.Course;
import com.example.project.sa2.springboot.repository.CourseRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseServices {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseServices.class);

    @Autowired
    private CourseRepo courseRepo;

    public DatabaseServices(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void insertCourse(Course course){

        CourseDb courseDb = new CourseDb();
        courseDb.setName(course.getName());
        courseDb.setHours(course.getHours());
        courseDb.setCode(course.getCode());

        courseRepo.save(courseDb);

        LOGGER.info(String.format("New course is inserted successfully in database! -> %s", courseDb.toString()));
    }

    public List<CourseDb> selectAllCourses(){
        LOGGER.info(String.format("All courses are selected successfully from database!"));
        return courseRepo.findAll();
    }

    public CourseDb selectOneCourse(int id){
        Optional<CourseDb> courseDb = courseRepo.findById(id);
        LOGGER.info(String.format("An course is selected successfully from database! id -> %d", id));
        return courseDb.orElse(null);
    }

    public void deleteAnCourse(int id){
        LOGGER.info(String.format("An course is deleted successfully from database! id -> %d", id));
        courseRepo.deleteById(id);
    }

    public CourseDb updateAnCourse(Course newCourse){
        Optional<CourseDb> oldCourse = courseRepo.findById(newCourse.getId());
        if (oldCourse.isPresent()){
            CourseDb course = oldCourse.get();

            course.setId(newCourse.getId());
            course.setName(newCourse.getName());
            course.setHours(newCourse.getHours());
            course.setCode(newCourse.getCode());

            LOGGER.info(String.format("An course is Updated successfully in database! -> %s", course.toString()));
            return courseRepo.save(course);
        }else {

            LOGGER.info(String.format("An course is not exist in database!"));
            return null;
        }
    }
}
