package com.liu.service.impl;

import com.liu.dao.CourseDao;
import com.liu.dao.TeacherDao;
import com.liu.domain.Course;
import com.liu.domain.Teacher;
import com.liu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Teacher> list() {
        List<Teacher> teacherList = teacherDao.findAll();
        for (Teacher teacher : teacherList) {
            Integer teacherId = teacher.getId();
           List<Course> courses =  courseDao.findCourseByTeacherId(teacherId);
           teacher.setCourses(courses);
        }
        return teacherList;
    }

    @Override
    public void save(Teacher teacher, Long[] courseIds) {
        Integer teacherId = teacherDao.save(teacher);
        teacherDao.saveTeacherCourseRelation(teacherId,courseIds);
    }
}
