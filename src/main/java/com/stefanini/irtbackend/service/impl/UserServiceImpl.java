package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.config.GenerateSecurePassword;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.dto.ChangePasswordRequest;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.EmailService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Transactional
    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.create(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Transactional
    @Override
    public User updateWithDto(UserDto userDto) {
        Long id = userDto.getId();
        User user = findById(id);

        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setSpecialty(userDto.getSpecialty());

        return userDao.update(user);
    }

    @Override
    @Transactional
    public void changePassword(Long userId, ChangePasswordRequest request) {
        User user = userDao.findById(userId).orElseThrow(() -> new NotFoundException("Not found user with id = " + userId));
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userDao.update(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElseThrow(() -> new NotFoundException("Not found user with id = " + id));
    }

    @Override
    @Transactional
    public User findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        User byId = userDao.findById(id).orElseThrow(() -> new NotFoundException("Not found user with id = " + id));
        userDao.delete(byId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email).orElseThrow(() -> new NotFoundException("Invalid email [" + email + "]"));
    }

    @Override
    public void resetPasswordFor(String email) {
        User userByEmail = userDao.findByEmail(email).orElseThrow(() -> new NotFoundException("Not found user with email = " + email));
        String temporaryPassword = GenerateSecurePassword.generatePassword(5);
        String encodedPassword = passwordEncoder.encode(temporaryPassword);
        userByEmail.setPassword(encodedPassword);
        userDao.update(userByEmail);

        emailService.sendResetPasswordEmail(email, temporaryPassword);
    }
}
