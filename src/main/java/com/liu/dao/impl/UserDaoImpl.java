package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.domain.SUser;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SUser> findAll() {
        String sql = "select * from s_user ";
        List<SUser> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SUser>(SUser.class));
//        System.out.println(userList.get(29));
        return userList;
    }

    @Override
    public int findTotalCount() {
        String sql = "select count(*) from s_user ";
        Integer totalCount = jdbcTemplate.queryForObject(sql, Integer.class);
        return totalCount;
    }

    @Override
    public List<SUser> findByPage(int start, int rows) {
        String sql = "select * from s_user limit ? , ? ";
        List<SUser> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SUser>(SUser.class), start, rows);
        return userList;
    }

    @Override
    public Long save(final SUser user) {
        final String sql = "insert into s_user values(?,?,?,?,?,?,?) ";
//        jdbcTemplate.update(sql,user.getId(),user.getSno(),user.getName(),user.getSex(),user.getAddress(),user.getPhone(),user.getPassword());
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成PreparedStatementCreator的组建
                PreparedStatement preparedStatement = connection.prepareStatement(sql, com.mysql.jdbc.PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, null);
                preparedStatement.setString(2, user.getSno());
                preparedStatement.setString(3, user.getName());
                preparedStatement.setString(4, user.getSex());
                preparedStatement.setString(5, user.getAddress());
                preparedStatement.setString(6, user.getPhone());
                preparedStatement.setString(7, user.getPassword());
                return preparedStatement;
            }
        };
        //创建GeneratedKeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator, keyHolder);
        //获取生成的主键
        Long userId = keyHolder.getKey().longValue();
        return userId;
    }

    @Override
    public void saveUserRoleRelation(Long id, Long[] roleIDs) {
        String sql = "insert into s_user_role values(?,?) ";
        for (Long roleID : roleIDs) {
            jdbcTemplate.update(sql, id, roleID);
        }
    }

    /*TODO 先删除user_role表中的联系,才能删除user表中的数据,不然又外键约束,删不掉*/
    @Override
    public void delUserRoleRelation(Long userId) {
        String sql = "delete from s_user_role where userid = ? ";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public void delUser(Long userId) {
        String sql = "delete from s_user where id = ? ";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public SUser findUserByUsernameAndPassword(String username, String password) throws EmptyResultDataAccessException {
        String sql = "select * from s_user where sno = ? and password = ? ";
        SUser sUser = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(SUser.class), username, password);
        return sUser;

    }
}
