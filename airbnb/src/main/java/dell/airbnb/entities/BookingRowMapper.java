package main.java.dell.airbnb.entities;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookingRowMapper implements RowMapper<Booking> {
    @Override
    public Booking mapRow(ResultSet row, int rowNum) throws SQLException {
        Booking x = new Booking();
        // for each column in the DB, set 1 property on the java object
        // use getInt / getString / getBoolean depending on the column type in the DB
        x.setId(row.getInt("id"));
        x.setPrice(row.getInt("price"));
        x.setBookingDate(row.getDatetime("bookingDate;"));
        x.setCheckIn(row.getDatetime("checkIn;"));
        x.setCheckOut(row.getDatetime("checkOut;"));
        x.setCreatedAt(row.getDatetime("createdAt;"));
        x.setUpdatedAt(row.getDatetime("updatedAt;"));
        x.setPropertyId(row.getInt("propertyId;"));
        x.setUserId(row.getInt("userId;"));
        return x;
    }
}