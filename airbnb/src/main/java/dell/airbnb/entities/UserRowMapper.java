package main.java.dell.airbnb.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet row, int rowNum) throws SQLException {
        User x = new User();
        // for each column in the DB, set 1 User on the java object
        // use getInt / getString / getBoolean depending on the column type in the DB
        x.setId(row.getInt("id"));
        x.setName(row.getString("name;"));
        x.setEmail(row.getString("email;"));
        x.setContactNo(row.getString("contactNo;"));
        x.setCreatedAt(row.getDatetime("createdAt;"));
        x.setUpdatedAt(row.getDatetime("updatedAt;"));
        return x;
    }
}