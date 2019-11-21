package main.java.dell.airbnb.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dell.airbnb.entities.User;
import dell.airbnb.entities.UserRowMapper;

@Transactional
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    //Retrieve all records
    public List<User> getAll() {
        String sql = "SELECT * FROM user";
        RowMapper<User> rowMapper = new UserRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    } 

    //Retrieve one record
    public User getOne(int userId){
        String sql = "SELECT * FROM user WHERE id = ?";
        RowMapper<User> rowMapper = new UserRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, userId );
    }

    //Create one record
    public List<User> createUser(User user){
        String sql = "INSERT INTO user (name, email, contactNo, createdAt, updatedAt) VALUES (?, ? , ?, ?, ?)";
        RowMapper<User> rowMapper = new UserRowMapper();
        return jdbcTemplate.query(sql, rowMapper, name, email, contactNo, createdAt, updatedAt);
    }

    //Update one record
    public void updateUser(int userId, main.java.dell.airbnb.entities.User user){
        String sql = "UPDATE user SET name = ?, email = ?, contactNo = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getContactNo(), user.getCreatedAt(), user.getUpdatedAt(), userId);
    }

    //Delete one record
    public void deleteUser(int userId){
        String sql = "DELETE FROM user WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }

    //Record validation
    public Boolean userExists(int userId){
        String sql = "SELECT count(*) FROM user WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }
}