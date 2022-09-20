package com.example.dto;


import javax.validation.constraints.*;

public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 5, max = 45, message = "Do dai toi thieu 5, toi da 45 ky tu")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45, message = "Do dai toi thieu 5, toi da 45 ky tu")
    private String lastName;

    @Pattern(regexp = "^09[0-9]{8}$",message = "10 so bat dau bang so 09")
    private String phoneNumber;

    @Pattern(regexp = "^1[89]|[2-5]\\d|60$", message = "Tuoi >= 18")
    private String age;

    @Pattern(regexp = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$",message = "email khong hop le (ex:abc@gmail.com)!!")
    private String email;


    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
