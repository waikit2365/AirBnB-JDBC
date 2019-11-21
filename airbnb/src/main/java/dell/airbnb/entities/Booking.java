package main.java.dell.airbnb.entities;

public class Booking {
    private int id;
    private int price;
    private Datetime bookingDate;
    private Datetime checkIn;
    private Datetime checkOut;
    private Datetime createdAt;
    private Datetime updatedAt;
    private int propertyId;
    private int userId;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Datetime getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(Datetime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Datetime getCheckIn() {
        return this.checkIn;
    }

    public void setCheckIn(Datetime checkIn) {
        this.checkIn = checkIn;
    }

    public Datetime getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(Datetime checkOut) {
        this.checkOut = checkOut;
    }

    public Datetime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Datetime createdAt) {
        this.createdAt = createdAt;
    }

    public Datetime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Datetime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}