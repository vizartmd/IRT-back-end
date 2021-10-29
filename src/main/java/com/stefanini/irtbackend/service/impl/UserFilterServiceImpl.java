package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.RoleName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import com.stefanini.irtbackend.service.UserFilterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFilterServiceImpl implements UserFilterService {

    private final UserDao userDao;

    public UserFilterServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> applyAllFilters(UserDto userDto) {
        List<User> users = userDao.findAll();

        if (userDto == null){
            return users;
        }

        List<User> result = filterByUsername(users, userDto.getUsername());
        result = filterByFirstName(result, userDto.getFirstName());
        result = filterByLastName(result, userDto.getLastName());
        result = filterByEmail(result, userDto.getEmail());
        result = filterByRole(result, userDto.getRole());
        result = filterBySpecialty(result, userDto.getSpecialty());
        return result;
    }

    @Override
    public List<User> filterByUsername(List<User> users, String username) {
        if (username.isEmpty())
            return users;
        return users.stream().filter(user -> user.getUsername().contains(username)).collect(Collectors.toList());
    }

    @Override
    public List<User> filterByFirstName(List<User> users, String firstName) {
        if (firstName.isEmpty())
            return users;
        return users.stream().filter(user -> user.getFirstName().contains(firstName)).collect(Collectors.toList());
    }

    @Override
    public List<User> filterByLastName(List<User> users, String lastName) {
        if (lastName.isEmpty())
            return users;
        return users.stream().filter(user -> user.getLastName().contains(lastName)).collect(Collectors.toList());
    }

    @Override
    public List<User> filterByEmail(List<User> users, String email) {
        if (email.isEmpty())
            return users;
        return users.stream().filter(user -> user.getEmail().contains(email)).collect(Collectors.toList());
    }

    @Override
    public List<User> filterByRole(List<User> users, RoleName role) {
        if (role == null)
            return users;
        return users.stream().filter(user -> user.getRole().equals(role)).collect(Collectors.toList());
    }

    @Override
    public List<User> filterBySpecialty(List<User> users, SpecialtyName specialty) {
        if (specialty == null)
            return users;
        return users.stream().filter(user -> user.getSpecialty().equals(specialty)).collect(Collectors.toList());
    }
}
