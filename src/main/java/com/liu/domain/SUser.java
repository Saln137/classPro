package com.liu.domain;

import java.io.Serializable;
import java.util.List;

/**
 * (SUser)实体类
 *
 * @author makejava
 * @since 2022-04-08 10:20:55
 */
public class SUser implements Serializable {
    private static final long serialVersionUID = 502353320730449458L;
    
    private Integer id;
    
    private String sno;
    
    private String name;
    
    private String sex;
    
    private String address;
    
    private String phone;
    
    private String password;

    //当前用户具备的角色
    private List<SRole> roles;

    public List<SRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SRole> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SUser{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

