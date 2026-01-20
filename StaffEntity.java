package com.devmart.staffsphereservice;

import jakarta.persistence.*;

@Entity
@Table(name = "staff_profile")
public class StaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;

    private String staffName;
    private String role;
    private double salary;
    private String department;
    private String shiftTiming;

    // Constructors
    public StaffEntity() {}

    public StaffEntity(String staffName, String role, double salary,
                        String department, String shiftTiming) {
        this.staffName = staffName;
        this.role = role;
        this.salary = salary;
        this.department = department;
        this.shiftTiming = shiftTiming;
    }

    // Getters & Setters
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShiftTiming() {
        return shiftTiming;
    }

    public void setShiftTiming(String shiftTiming) {
        this.shiftTiming = shiftTiming;
    }
}
