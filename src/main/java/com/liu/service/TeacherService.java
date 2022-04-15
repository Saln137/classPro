package com.liu.service;

import com.liu.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> list();

    void save(Teacher teacher, Long[] courseIds);
}
