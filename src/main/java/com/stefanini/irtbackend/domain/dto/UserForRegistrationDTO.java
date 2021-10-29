package com.stefanini.irtbackend.domain.dto;

import com.stefanini.irtbackend.domain.entity.enums.RoleName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;

public class UserForRegistrationDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private RoleName role;
    private SpecialtyName specialty;

    public UserForRegistrationDTO() {
    }

    public UserForRegistrationDTO(String id, String firstName, String lastName, String userName,
                                  String email, String password, RoleName role, SpecialtyName specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.specialty = specialty;
    }

    public UserForRegistrationDTO(String firstName, String lastName, String userName, String email,
                                  String password, RoleName role, SpecialtyName specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.specialty = specialty;
    }

    public UserForRegistrationDTO(String firstName, String lastName, String userName, String email,
                                  RoleName role, SpecialtyName specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.specialty = specialty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public SpecialtyName getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyName specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "UserForRegistrationDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", specialty=" + specialty +
                '}';
    }
}
