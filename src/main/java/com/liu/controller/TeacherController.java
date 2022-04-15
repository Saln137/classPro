package com.liu.controller;

import com.liu.domain.Course;
import com.liu.domain.Teacher;
import com.liu.service.CourseService;
import com.liu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Teacher> teacherList = teacherService.list();
        modelAndView.addObject("teacherList",teacherList);
        modelAndView.setViewName("teacher-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(ModelAndView modelAndView){
        List<Course> courseList = courseService.list();
        modelAndView.addObject("courseList",courseList);
        modelAndView.setViewName("teacher-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Teacher teacher,Long[] courseIds){
        teacherService.save(teacher,courseIds);
        return "redirect:/teacher/list";
    }
}
