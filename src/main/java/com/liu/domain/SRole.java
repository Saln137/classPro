package com.liu.domain;

import java.io.Serializable;

/**
 * (SRole)实体类
 *
 * @author makejava
 * @since 2022-04-08 09:07:54
 */
public class SRole implements Serializable {
    private static final long serialVersionUID = -97889411905715810L;
    
    private Integer id;
    
    private String rname;
    
    private String rdesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    @Override
    public String toString() {
        return "SRole{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", rdesc='" + rdesc + '\'' +
                '}';
    }
}

