package com.example.electionCom.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.electionCom.entity.Candidate;
import com.example.electionCom.entity.Student;

@Repository
public class CandidateJdbcRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	String INSERT_MESSAGE_SQL 
	  = "insert into candidate (student_id, description, status) " + "values(?, ?, ?)";
	
	
	public List < Candidate > findAll() {
		return jdbcTemplate.query("select * from candidate", new CandidateRowMapper());
	}
	
	public int updateStatus(Candidate candidate) {
	    return jdbcTemplate.update("update candidate " + " set status = ? " + " where id = ?",
	        new Object[] {
	            candidate.getStatus(), candidate.getId()
	        });
	}
	
	public Candidate findById(Long id) {
		return jdbcTemplate.queryForObject("select * from candidate where id=?", new Object[] {
				id
        },
        new BeanPropertyRowMapper < Candidate > (Candidate.class));
	}
	
	
	public Candidate findByStudentId(Long studentId) {
		return jdbcTemplate.queryForObject("select * from candidate where student_id=?", new Object[] {
				studentId
        },
        new BeanPropertyRowMapper < Candidate > (Candidate.class));
	}
	
	public void insertPS(Candidate candidate) {    
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
	 
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(INSERT_MESSAGE_SQL);
	          ps.setLong(1, candidate.getStudentId());
	          ps.setString(2, candidate.getDescription());
	          ps.setInt(3,  candidate.getStatus());
 	          return ps;
	        }, keyHolder);
	}
}


class CandidateRowMapper implements RowMapper < Candidate > {
	
    public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Candidate candidate = new Candidate();
    		candidate.setId(rs.getLong("id"));
    		candidate.setStudentId(rs.getLong("student_id"));
    		candidate.setDescription(rs.getString("description"));
    		candidate.setStatus(rs.getInt("status"));
        return candidate;
    }
}