package com.liu.controller;

import com.liu.domain.Course;
import com.liu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        List<Course> courseList = courseService.list();
        modelAndView.addObject("courseList",courseList);
        modelAndView.setViewName("course-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Course course){
        courseService.save(course);
        return "redirect:/course/list";
    }
}
