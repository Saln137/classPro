package com.liu.dao;

import com.liu.domain.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> findAll();

    Integer save(Teacher teacher);

    void saveTeacherCourseRelation(Integer teacherId, Long[] courseIds);
}
