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

import com.example.electionCom.entity.Student;
import com.example.electionCom.entity.Vote;

@Repository
public class ElectionJdbcRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;
    
	String INSERT_MESSAGE_SQL 
	  = "insert into student_election (voter_id, candidate_id, role_id) " + "values(?, ?, ?)";
	
	
	public List < Vote > findAll() {
		return jdbcTemplate.query("select * from student_election", new VoteRowMapper());
	}
	 
	public Vote find(long voter_id, long candidate_id) {
	
		return jdbcTemplate.queryForObject("select * from student_election where voter_id=?", new Object[] {
				voter_id
        },
        new BeanPropertyRowMapper < Vote > (Vote.class));
	
	}
	 
	public void insertPS(Vote vote) {    
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
	 
	    jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(INSERT_MESSAGE_SQL);
	          ps.setLong(1, vote.getVoterId());
	          ps.setLong(2, vote.getCandidateId());
	          ps.setLong(3, vote.getRoleId());
 	          return ps;
	        }, keyHolder);
	       
	    	
	}
	
	public int getVoteCount(long candidateId) {
		
		String sql = "select count(*) FROM student_election WHERE candidate_id = ?";


		int count = jdbcTemplate.queryForObject(
		                        sql, new Object[] { candidateId }, Integer.class);
		
		return count;
		
	}
	
}
class VoteRowMapper implements RowMapper < Vote > {
	
    public Vote mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Vote vote = new Vote();
    		vote.setId(rs.getLong("id"));
    		vote.setVoterId(rs.getLong("voted_id"));
    		vote.setCandidateId(rs.getLong("candidate_id"));
    		vote.setRoleId(rs.getLong("role_id"));

        return vote;
    }
}