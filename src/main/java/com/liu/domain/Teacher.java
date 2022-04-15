package com.liu.domain;

import java.io.Serializable;
import java.util.List;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2022-04-09 14:06:00
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 145807253226234972L;
    
    private Integer id;
    
    private String tno;
    
    private String tname;
    
    private String gender;
    
    private String tphone;
    
    private String password;

    /*当前教师所授课程*/
    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /*新建的课程*/
    private String course;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", gender='" + gender + '\'' +
                ", tphone='" + tphone + '\'' +
                ", password='" + password + '\'' +
                ", courses=" + courses +
                '}';
    }
}

