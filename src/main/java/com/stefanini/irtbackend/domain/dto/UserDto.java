package com.stefanini.irtbackend.domain.dto;

import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.RoleName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;

import java.util.Objects;

public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private RoleName role;
    private SpecialtyName specialty;
    private String accessToken;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserDto(String firstName, String lastName, String username, String email, RoleName role, SpecialtyName specialty, String accessToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.role = role;
        this.specialty = specialty;
        this.accessToken = accessToken;
    }
}
