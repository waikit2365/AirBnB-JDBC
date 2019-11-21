package main.java.dell.airbnb.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dell.airbnb.entities.Payment;
import dell.airbnb.entities.PaymentRowMapper;

@Transactional
@Repository
public class PaymentRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PaymentRepository(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
    }

    //Retrieve all records
    public List<Payment> getAll() {
        String sql = "SELECT * FROM payment";
        RowMapper<Payment> rowMapper = new PaymentRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    } 

    //Retrieve one record
    public Payment getOne(int paymentId){
        String sql = "SELECT * FROM payment WHERE id = ?";
        RowMapper<Payment> rowMapper = new PaymentRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, paymentId );
    }

    //Create one record
    public List<Payment> createPayment(Payment payment){
        String sql = "INSERT INTO payment (status, amount, bookingId) VALUES (?, ? , ?)";
        RowMapper<Payment> rowMapper = new PaymentRowMapper();
        return jdbcTemplate.query(sql, rowMapper, status, amount, bookingId);
    }

    //Update one record
    public void updatePayment(int paymentId, main.java.dell.airbnb.entities.Payment payment){
        String sql = "UPDATE payment SET status = ?, amount = ?, bookingId = ? WHERE id = ?";
        jdbcTemplate.update(sql, payment.getStatus(), payment.getAmount(), payment.getBookingId(), paymentId);
    }

    //Delete one record
    public void deletePayment(int paymentId){
        String sql = "DELETE FROM payment WHERE id = ?";
        jdbcTemplate.update(sql, paymentId);
    }

    //Record validation
    public Boolean paymentExists(int paymentId){
        String sql = "SELECT count(*) FROM payment WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, paymentId);
        if(count == 0) {
            return false;
        } else {
            return true;
        }
    }
}