package com.example.dto;


import com.example.model.Division;
import com.example.model.EducationDegree;
import com.example.model.Position;

public class EmployeeDto {
    private int id;
    private String employeeName;
    private String birthday;
    private String idCard;
    private String phone;
    private String email;
    private double salary;
    private EducationDegree educationDegree;
    private Position position;
    private Division division;
    public EmployeeDto() {
    }


    public EmployeeDto(int id, String employeeName, String birthday, String idCard, String phone, String email,
                       double salary, EducationDegree educationDegree, Position position, Division division) {
        this.id = id;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
