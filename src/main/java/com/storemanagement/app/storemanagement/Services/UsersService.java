package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.Entities.Users;
import com.storemanagement.app.storemanagement.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }


}
