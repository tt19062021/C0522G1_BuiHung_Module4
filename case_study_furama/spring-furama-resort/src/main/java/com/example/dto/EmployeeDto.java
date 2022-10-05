package com.example.dto;


import com.example.model.Contract;
import com.example.model.Division;
import com.example.model.EducationDegree;
import com.example.model.Position;

import java.util.Set;

public class EmployeeDto {
    private int id;
    private String nameEmployee;
    private String dateOfBirth;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String salary;
    private String address;
    private EducationDegree educationDegree;
    private Position position;
    private Division division;


    public EmployeeDto(int id, String nameEmployee, String dateOfBirth,
                       String idCard, String phoneNumber, String email,
                       String salary, String address, EducationDegree educationDegree,
                       Position position, Division division) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
    }

    public EmployeeDto() {
    }

    public EmployeeDto(String nameEmployee, String dateOfBirth, String idCard,
                       String phoneNumber, String email, String salary,
                       String address, EducationDegree educationDegree, Position position,
                       Division division) {
        this.nameEmployee = nameEmployee;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }


    public void setDivision(int id) {
    }
}
