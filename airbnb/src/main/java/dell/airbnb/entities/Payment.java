package main.java.dell.airbnb.entities;

public class Payment {
    private int id;
    private Boolean status;
    private int amount;
    private int bookingId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

}