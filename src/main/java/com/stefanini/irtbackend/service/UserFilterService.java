package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.RoleName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;

import java.util.List;

public interface UserFilterService {
    List<User> applyAllFilters(UserDto userDto);
    List<User> filterByUsername(List<User> users, String username);
    List<User> filterByFirstName(List<User> users, String firstName);
    List<User> filterByLastName(List<User> users, String lastName);
    List<User> filterByEmail(List<User> users, String email);
    List<User> filterByRole(List<User> users, RoleName role);
    List<User> filterBySpecialty(List<User> users, SpecialtyName specialty);
}
