package com.storemanagement.app.storemanagement.Controllers;


import com.storemanagement.app.storemanagement.Entities.Users;
import com.storemanagement.app.storemanagement.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UsersController {

    @Autowired
    UsersService usersService;
    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.findAllUsers();

    }
}
