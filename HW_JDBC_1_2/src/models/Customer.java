package models;

import java.sql.Date;
import java.util.Objects;

public class Customer {
    int id;
    String lastName;
    String firstName;
    String phone;
    String email;
    Date created;

    public Customer() {
    }

    public Customer(int id, String lastName, String firstName, String phone, String email, Date created) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(lastName, customer.lastName) && Objects.equals(firstName, customer.firstName) && Objects.equals(phone, customer.phone) && Objects.equals(email, customer.email) && Objects.equals(created, customer.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, phone, email, created);
    }
}
