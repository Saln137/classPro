package com.liu.dao.impl;

import com.liu.dao.RoleDao;
import com.liu.domain.SRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SRole> findAll() {
        String sql = "select * from s_role ";
        List<SRole> sRoles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SRole>(SRole.class));
//        System.out.println(sRoles);
        return sRoles;
    }

    @Override
    public void save(SRole sRole) {
        String sql = "insert into s_role values(null,?,?) ";
        int row = jdbcTemplate.update(sql, sRole.getRname(), sRole.getRdesc());
//        System.out.println(row);
    }

    @Override
    public List<SRole> findRoleByUserID(Integer id) {
        String sql = "select * from s_user_role ur , s_role r where ur.roleid = r.id and ur.userid = ? ";
        List<SRole> sRoles = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SRole>(SRole.class), id);
//        System.out.println(sRoles);
        return sRoles;
    }

}
