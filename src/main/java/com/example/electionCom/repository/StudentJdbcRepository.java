package com.example.electionCom.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.electionCom.entity.Student;
 
@Repository
public class StudentJdbcRepository {
	String INSERT_MESSAGE_SQL 
	  = "insert into student (username, password, name, passportnumber) " + "values(?, ?, ?, ?)";

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    
    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Student > (Student.class));
    }
    
    public Student findByUsername(String username, String password) {
    		return jdbcTemplate.queryForObject("select * from student where username=? and password=?", new Object[] {
        		username, password
            },
            new BeanPropertyRowMapper < Student > (Student.class));
    	
    }
    public Student findByPassport(String passportNumber) {
        return jdbcTemplate.queryForObject("select * from student where passportnumber=?", new Object[] {
        		passportNumber
            },
            new BeanPropertyRowMapper < Student > (Student.class));
    }
    
    
    public List < Student > findAll() {
	    return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}
    

	public int deleteById(long id) {
	    return jdbcTemplate.update("delete from student where id=?", new Object[] {
	        id
	    });
	}
	public int insert(Student student) {
	    return jdbcTemplate.update("insert into student (id, name, passportnumber) " + "values(?,  ?, ?)",
	        new Object[] {
	            student.getId(), student.getName(), student.getPassportNumber()
	        });
	}
	public int update(Student student) {
	    return jdbcTemplate.update("update student " + " set name = ?, passportnumber = ? " + " where id = ?",
	        new Object[] {
	            student.getName(), student.getPassportNumber(), student.getId()
	        });
	}
	
	public void insertPS(Student student) {    
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
	 
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(INSERT_MESSAGE_SQL);
	          ps.setString(1, student.getUsername());
	          ps.setString(2, student.getPassword());
	          ps.setString(3, student.getName());
	          ps.setString(4, student.getPassportNumber());
	          return ps;
	        }, keyHolder);
	       
	    	
	   }
	

    public int create(Student student) {
    		String sql_message = "insert into student (id, name, passportnumber) " + "values(:id, :name, :passportNumber)";
    		
    		
    	  
    	  SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(student);
    	  KeyHolder keyHolder = new GeneratedKeyHolder();
    	  jdbcTemplate.update(sql_message, fileParameters, keyHolder);
    	  return keyHolder.getKey().intValue();
    	}
}


class StudentRowMapper implements RowMapper < Student > {
	
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
    	    System.out.println(rs);
        Student student = new Student();
        student.setId(rs.getLong("id"));
        student.setUsername(rs.getString("username"));
        student.setPassword(rs.getString("password"));
        student.setName(rs.getString("name"));
        student.setPassportNumber(rs.getString("passportnumber"));
        return student;
    }
}