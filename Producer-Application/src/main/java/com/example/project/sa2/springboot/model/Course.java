package com.example.project.sa2.springboot.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Course {

    private int id;

    private String name;
    private int hours;
    private String code;
    private String operationType;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Hours='" + hours + '\'' +
                ", Code='" + code + '\'' +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
