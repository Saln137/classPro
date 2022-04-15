package com.liu.service;

import com.liu.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> list();

    void save(Course course);
}
