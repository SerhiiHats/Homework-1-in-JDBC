package models;

import java.sql.Date;
import java.util.Objects;

public class EmployeeManager {
    private String lName;
    private String fName;
    private String mName;
    private String titleJob;
    private Date birthday;
    private String phone;

    public EmployeeManager(String lName, String fName, String mName, String titleJob, Date birthday, String phone) {
        this.lName = lName;
        this.fName = fName;
        this.mName = mName;
        this.titleJob = titleJob;
        this.birthday = birthday;
        this.phone = phone;
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

    public String getTitleJob() {
        return titleJob;
    }

    public void setTitleJob(String titleJob) {
        this.titleJob = titleJob;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "EmployeeManager{" +
                "lName='" + lName + '\'' +
                ", fName='" + fName + '\'' +
                ", mName='" + mName + '\'' +
                ", titleJob='" + titleJob + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeManager that = (EmployeeManager) o;
        return Objects.equals(lName, that.lName) && Objects.equals(fName, that.fName) && Objects.equals(mName, that.mName) && Objects.equals(titleJob, that.titleJob) && Objects.equals(birthday, that.birthday) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lName, fName, mName, titleJob, birthday, phone);
    }
}
