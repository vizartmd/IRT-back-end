//package com.stefanini.irtbackend.controller;
//
//import com.stefanini.irtbackend.entity.User;
//import com.stefanini.irtbackend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping(value = "/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "/get", method = RequestMethod.POST)
//    @ResponseBody
//    public User getMockUser() {
//        return createMockUser();
//    }
//
//    private User createMockUser() {
////        User user = new User();
////        user.setName("MockName");
////        user.setRollNumber("100000");
////        user.setUniversity("UTM");
//        return null;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    @ResponseBody
//    public User saveUser(@RequestBody User user) {
//        User userResponse = (User) userService.saveUser(user);
//        return userResponse;
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.PUT)
//    @ResponseBody
//    public User updateUser(@RequestBody User user) {
//        User userResponse = (User) userService.updateUser(user);
//        return userResponse;
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//    @ResponseBody
//    public User deleteUser(@RequestBody User user) {
//        User userResponse = (User) userService.deleteUser(user);
//        return userResponse;
//    }
//
//    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public User getUser(@PathVariable long id) {
//
//        User userResponse = (User) userService.getUser(id);
//        return userResponse;
//    }
//
//}
