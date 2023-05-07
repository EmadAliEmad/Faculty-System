package com.example.project.sa2.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
@Table(name = "courses")
public class CourseDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Hours")
    private int hours;
    @Column(name = "Code")
    private String code;

    @Override
    public String toString() {
        return "CourseDb{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Hours='" + hours + '\'' +
                ", Code='" + code + '\'' +
                '}';
    }
}
