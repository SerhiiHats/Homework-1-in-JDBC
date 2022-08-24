package models;

import java.util.Objects;

public class EmployeePhone {
    private String lName;
    private String fName;
    private String mName;
    private String phone;
    private String address;

    public EmployeePhone(String lName, String fName, String mName, String phone, String address) {
        this.lName = lName;
        this.fName = fName;
        this.mName = mName;
        this.phone = phone;
        this.address = address;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeePhone{" +
                "lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", mName='" + mName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePhone that = (EmployeePhone) o;
        return Objects.equals(lName, that.lName) && Objects.equals(fName, that.fName) && Objects.equals(mName, that.mName) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lName, fName, mName, phone, address);
    }
}
