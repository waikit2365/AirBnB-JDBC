package main.java.dell.airbnb.entities;

public class Property {
    private int id;
    private String address;
    private int ownerId;
    private Datetime createdAt;
    private Datetime updatedAt;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

}