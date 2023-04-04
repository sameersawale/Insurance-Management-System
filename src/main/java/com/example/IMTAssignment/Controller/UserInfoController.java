package com.example.IMTAssignment.Controller;


import com.example.IMTAssignment.Models.UserInfo;
import com.example.IMTAssignment.Service.ServiceImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }
}
