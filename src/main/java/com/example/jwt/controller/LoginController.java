package com.example.jwt.controller;


import com.example.jwt.service.UserService;
import com.example.jwt.uitl.JwtUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping("/registration")
    @ResponseBody
    public String register(@RequestParam String username, HttpServletResponse response) {
        String jwt = JwtUitl.generateToken(username);
        response.setHeader("Authorization", jwt);

        return String.format("JWT for %s :\n%s", username, jwt);
    }

    @GetMapping("/api")
    @ResponseBody
    public String testApi(HttpServletRequest request, HttpServletResponse response) {
        String oldJwt = request.getHeader("Authorization");
        String newJwt = response.getHeader("Authorization");

        return String.format("Your old JWT is:\n%s \nYour new JWT is:\n%s\n", oldJwt, newJwt);
    }

}
