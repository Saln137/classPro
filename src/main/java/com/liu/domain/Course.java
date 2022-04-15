package com.liu.domain;

import java.io.Serializable;

/**
 * (Course)实体类
 *
 * @author makejava
 * @since 2022-04-09 14:09:05
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 639964619407964536L;
    
    private Integer id;
    
    private String cname;
    
    private Double credit;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

}

