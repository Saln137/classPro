package com.liu.dao.impl;

import com.liu.dao.IPDao;
import com.liu.domain.IPBean;
import com.liu.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IPDaoImpl implements IPDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveLog(String ipRequest, String s_date,String address,String outerIP) {
        String sql = "insert into logtab(username, interIP, outerIP, address, time) values(?,?,?,?,?) ";
//        IPBean ipBean = new IPBean();
//        String address = ipBean.getCountry()+ipBean.getArea()+ipBean.getRegion()+ipBean.getCity()+ipBean.getIsp();
        System.out.println(address);
        int rows = 0;
        try {
            rows = jdbcTemplate.update(sql, null, ipRequest, outerIP, address, s_date);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(rows);
    }

    @Override
    public void saveName(String name) {
        String sql = "insert into logtab(username) values(?) ";
        try {
            jdbcTemplate.update(sql, name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Log> list() {
        String sql = "select * from logtab ";
        List<Log> logList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Log>(Log.class));
        return logList;
    }
}
