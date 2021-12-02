package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.config.security.RandomStringGenerator;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.PasswordsMismatchException;
import com.stefanini.irtbackend.domain.WrongPasswordException;
import com.stefanini.irtbackend.domain.WrongVerificationCodeException;
import com.stefanini.irtbackend.domain.dto.ChangeForgottenPasswordRequest;
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
public class UserServiceImpl implements UserService {


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
        return userDao.findByEmail(email).orElseThrow(() -> new NotFoundException("Bad credentials"));
    }

    @Override
    public List<String> findAllUsernamesBySpecialty(String specialty) {
        return userDao.findAllUsernamesBySpecialty(specialty);
    }

    @Override
    public List<String> findAllUsernamesByRole(String role) {
        return userDao.findAllUsernamesByRole(role);
    }

    @Transactional
    public void sendForgotPasswordVerificationCode(String email) {
        User userByEmail = userDao.findByEmail(email).orElseThrow(() -> new NotFoundException("Not found user with email = " + email));
        String verificationCode = RandomStringGenerator.generate(5);
        userByEmail.setVerificationCode(verificationCode);
        userDao.update(userByEmail);
        emailService.sendVerificationCodeEmail(email, verificationCode);
    }

    @Override
    @Transactional
    public void changePasswordFor(Long userId, ChangePasswordRequest request) {
        if (!request.getNewPassword().equals(request.getNewPasswordConfirmation()))
            throw new PasswordsMismatchException("New & confirmed passwords are not equal!");

        User user = userDao.findById(userId).orElseThrow(() -> new NotFoundException("Not found user with id = " + userId));

        String currentPassword = request.getCurrentPassword();
        String userPassword = user.getPassword();

        if (!passwordEncoder.matches(currentPassword, userPassword))
            throw new WrongPasswordException("Wrong current password entered!");

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userDao.update(user);
    }

    @Override
    @Transactional
    public void changeForgottenPassword(ChangeForgottenPasswordRequest request) {
        if (!request.getNewPassword().equals(request.getNewPasswordConfirmation()))
            throw new PasswordsMismatchException("New & confirmed passwords are not equal!");

        User user = userDao.findByEmail(request.getEmail()).orElseThrow(() -> new NotFoundException("Not found user with email = " + request.getEmail()));

        String verificationCode = request.getVerificationCode();

        if (!verificationCode.equals(user.getVerificationCode()))
            throw new WrongVerificationCodeException("Wrong validation code!");

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userDao.update(user);
        user.setVerificationCode(" ");
    }

    public List<User> findAllBySpecialty(String specialty) {
        return userDao.findAllBySpecialty(specialty);
    }
}
