package main.java.dell.airbnb.entities;

public class User {
    private int id;
    private String name;
    private String email;
    private String contactNo;
    private Datetime createdAt;
    private Datetime updatedAt;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return this.contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
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