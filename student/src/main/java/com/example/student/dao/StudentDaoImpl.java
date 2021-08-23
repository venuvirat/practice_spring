package com.example.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.student.controller.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Student getStudentById(int id) {
		String sql = "select s_id,s_name,s_marks,city from student where s_id=:id";
		return namedParameterJdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id),
				new RowMapper<Student>() {

					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student s = new Student();
						s.setsId(rs.getInt("s_id"));
						s.setsName(rs.getString("s_name"));
						s.setsMarks(rs.getFloat("s_marks"));
						s.setCity(rs.getString("city"));
						return s;
					}

				});

	}

	@Override
	public void saveStudent(Student student) {
		String sql = "insert into student values(:s_id,:s_name,:s_marks,:city) ";
		// KeyHolder holder =new GeneratedKeyHolder();
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("s_id", student.getsId());
		params.addValue("s_name", student.getsName());
		params.addValue("s_marks", student.getsMarks());
		params.addValue("city", student.getCity());
		namedParameterJdbcTemplate.update(sql, params);
	}

	@Override
	public List<Student> getAllStudents() {
		String sql = "select s_id,s_name,s_marks,city from student";
		return namedParameterJdbcTemplate.query(sql, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setsId(rs.getInt("s_id"));
				s.setsName(rs.getString("s_name"));
				s.setsMarks(rs.getFloat("s_marks"));
				s.setCity(rs.getString("city"));
				return s;
			}
		});
	}

}
