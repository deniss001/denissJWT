package com.example.jwt;

import com.example.jwt.model.User;
import com.example.jwt.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtApplicationTests {

    @Autowired
    private UserService service;

    @Test
    public void contextLoads() {
        List<User> userList = service.findAll();
        System.out.println(userList);
    }

}
