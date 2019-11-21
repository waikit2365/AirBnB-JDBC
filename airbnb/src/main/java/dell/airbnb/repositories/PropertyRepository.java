package main.java.dell.airbnb.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dell.airbnb.entities.Property;
import dell.airbnb.entities.PropertyRowMapper;

@Transactional
@Repository
public class PropertyRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PropertyRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    //Retrieve all records
    public List<Property> getAll() {
        String sql = "SELECT * FROM property";
        RowMapper<Property> rowMapper = new PropertyRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    } 

    //Retrieve one record
    public Property getOne(int propertyId){
        String sql = "SELECT * FROM property WHERE id = ?";
        RowMapper<Property> rowMapper = new PropertyRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, propertyId );
    }

    //Create one record
    public List<Property> createProperty(Property property){
        String sql = "INSERT INTO property (address, ownerId, createdAt, updatedAt) VALUES (?, ? , ?, ?)";
        RowMapper<Property> rowMapper = new PropertyRowMapper();
        return jdbcTemplate.query(sql, rowMapper, address, ownerId, createdAt, updatedAt);
    }

    //Update one record
    public void updateProperty(int propertyId, main.java.dell.airbnb.entities.Property property){
        String sql = "UPDATE property SET address = ?, ownerId = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        jdbcTemplate.update(sql, property.getAddress(), property.getOwnerId(), property.getCreatedAt(), property.getUpdatedAt(), propertyId);
    }

    //Delete one record
    public void deleteProperty(int propertyId){
        String sql = "DELETE FROM property WHERE id = ?";
        jdbcTemplate.update(sql, propertyId);
    }

    //Record validation
    public Boolean propertyExists(int propertyId){
        String sql = "SELECT count(*) FROM property WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, propertyId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }
}