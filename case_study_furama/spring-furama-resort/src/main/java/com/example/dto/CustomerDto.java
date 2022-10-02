package com.example.dto;


import com.example.model.Contract;
import com.example.model.CustomerType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;


public class CustomerDto {

    private int id;

    @NotBlank(message = "Trường này không được để trống !!!")
    @Size(min=5,max = 100,message = "Trường Tên được giới hạn từ 5 - 100 kí tự")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",
            message = "Tên phải đúng định dạng mỗi chữ cái đầu phải viết in hoa")
    private String name;
    private String dateOfBirth;
    private String gender;

    @Pattern(regexp = "\\d{10}",message = "CMND phải đúng định dạng 10 số")
    private String idCard;

    @Pattern(regexp = "^((\\(\\+84\\-\\))|0)(90|91)[0-9]{7}$")
    private String phone;

    @Email(message = "Định dạng Email sai, hãy nhập đúng Email !!!")
    private String email;
    private String address;
    private CustomerType customerType;
    private Set<Contract> contractSet;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String dateOfBirth, String gender,
                       String idCard, String phone, String email, String address,
                       CustomerType customerType, Set<Contract> contractSet) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contractSet = contractSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
