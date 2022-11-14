package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.Entities.Users;
import com.storemanagement.app.storemanagement.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
}
