package com.stefanini.irtbackend.dto;

import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.enums.Role;
import com.stefanini.irtbackend.enums.Specialty;

import java.util.Objects;

public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Role role;
    private Specialty specialty;
    private String accessToken;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setSpecialty(user.getSpecialty());
        return userDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(firstName, userDto.firstName) && Objects.equals(lastName, userDto.lastName) && Objects.equals(username, userDto.username) && Objects.equals(email, userDto.email) && role == userDto.role && specialty == userDto.specialty && Objects.equals(accessToken, userDto.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, username, email, role, specialty, accessToken);
    }

    public UserDto() {
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
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserDto(String firstName, String lastName, String username, String email, Role role, Specialty specialty, String accessToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.role = role;
        this.specialty = specialty;
        this.accessToken = accessToken;
    }
}
