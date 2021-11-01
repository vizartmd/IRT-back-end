package com.stefanini.irtbackend.web.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String getSuccessPage() {
        return "success";
    }
}
