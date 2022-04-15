package com.liu.service.impl;

import com.liu.dao.CourseDao;
import com.liu.dao.impl.CourseDaoImpl;
import com.liu.domain.Course;
import com.liu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    public void setCourseDao(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> list() {
        List<Course> courseList = courseDao.findAll();
        return courseList;
    }

    @Override
    public void save(Course course) {
        courseDao.save(course);
    }
}
