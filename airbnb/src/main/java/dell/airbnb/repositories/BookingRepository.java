package main.java.dell.airbnb.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dell.airbnb.entities.Booking;
import dell.airbnb.entities.BookingRowMapper;

@Transactional
@Repository
public class BookingRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    //Retrieve all records
    public List<Booking> getAll() {
        String sql = "SELECT * FROM booking";
        RowMapper<Booking> rowMapper = new BookingRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    } 

    //Retrieve one record
    public Booking getOne(int bookingId){
        String sql = "SELECT * FROM booking WHERE id = ?";
        RowMapper<Booking> rowMapper = new BookingRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, bookingId );
    }

    //Create one record
    public List<Booking> createBooking(Booking booking){
        String sql = "INSERT INTO booking (price, bookingDate, checkIn, checkOut, createdAt, updatedAt, propertyId, userId) VALUES (?, ? , ?, ?, ? , ?, ?, ?)";
        RowMapper<Booking> rowMapper = new BookingRowMapper();
        return jdbcTemplate.query(sql, rowMapper, price, bookingDate, checkIn, checkOut, createdAt, updatedAt, propertyId, userId);
    }

    //Update one record
    public void updateBooking(int bookingId, main.java.dell.airbnb.entities.Booking booking){
        String sql = "UPDATE booking SET price = ?, bookingDate = ?, checkIn = ?, checkOut = ?, createdAt = ?, updatedAt = ?, propertyId = ?, userId = ? WHERE id = ?";
        jdbcTemplate.update(sql, booking.getPrice(), booking.getBookingDate(), booking.getCheckIn(), booking.getCheckOut(), booking.getCreatedAt(), booking.getUpdatedAt(), booking.getPropertyId(), booking.getUserId(), bookingId);
    }

    //Delete one record
    public void deleteBooking(int bookingId){
        String sql = "DELETE FROM booking WHERE id = ?";
        jdbcTemplate.update(sql, bookingId);
    }

    //Record validation
    public Boolean bookingExists(int bookingId){
        String sql = "SELECT count(*) FROM booking WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, bookingId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }
}