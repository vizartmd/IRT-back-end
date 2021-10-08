package com.stefanini.irtbackend.controller;

import com.stefanini.irtbackend.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MainController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  @ResponseBody
  public String getMockUser() {
      return "DDDDDDDD";
  }

}
