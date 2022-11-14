package com.storemanagement.app.storemanagement.Controllers;


import com.storemanagement.app.storemanagement.DTOs.UsersDTO;
import com.storemanagement.app.storemanagement.Entities.Users;
import com.storemanagement.app.storemanagement.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UsersController {

    @Autowired
    UsersService usersService;
    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping(path = "{name}")
    public Users getUser(@PathVariable String name){
        return usersService.getUserByName(name);
    }

    @PostMapping(path = "/add")
    public void addUser(@RequestBody UsersDTO userDTO){
        usersService.addUser(userDTO);
    }
}
