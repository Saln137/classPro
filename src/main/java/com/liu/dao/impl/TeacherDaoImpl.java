package com.liu.dao.impl;

import com.liu.dao.TeacherDao;
import com.liu.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Teacher> findAll() {
        String sql = "select * from teacher ";
        List<Teacher> teacherList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Teacher>(Teacher.class));
        return teacherList;
    }

    @Override
    public Integer save(final Teacher teacher) {
        final String sql = "insert into teacher values(?,?,?,?,?,?) ";
//        jdbcTemplate.update(sql, teacher.getTno(), teacher.getTname(), teacher.getGender(),
//                teacher.getTphone(), teacher.getPassword(),teacher.getCourse());
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成PreparedStatementCreator的组建
                PreparedStatement preparedStatement = connection.prepareStatement(sql, com.mysql.jdbc.PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,teacher.getTno());
                preparedStatement.setString(3, teacher.getTname());
                preparedStatement.setString(4,teacher.getGender());
                preparedStatement.setString(5,teacher.getTphone());
                preparedStatement.setString(6,teacher.getPassword());
                return preparedStatement;
            }
        };
        //创建GeneratedKeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        int teacherId  = keyHolder.getKey().intValue();
        return teacherId;
    }

    @Override
    public void saveTeacherCourseRelation(Integer teacherId, Long[] courseIds) {
        String sql = "insert into t_teacher_course values(?,?) ";
        for (Long courseId : courseIds) {
            jdbcTemplate.update(sql,teacherId,courseId);
        }
    }
}
