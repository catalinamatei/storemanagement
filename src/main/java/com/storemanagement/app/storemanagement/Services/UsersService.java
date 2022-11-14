package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.DTOs.ProductsDTO;
import com.storemanagement.app.storemanagement.DTOs.UsersDTO;
import com.storemanagement.app.storemanagement.Entities.Products;
import com.storemanagement.app.storemanagement.Entities.Users;
import com.storemanagement.app.storemanagement.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users getUserByName(String name){
        return usersRepository.findByName(name);
    }

    public void addUser(UsersDTO usersDTO){
        Users user = Users.builder()
                .title(usersDTO.getTitle())
                .name(usersDTO.getName())
                .build();
        usersRepository.save(user);
    }

    public void deleteUser(String name){
        usersRepository.delete(usersRepository.findByName(name));
    }

    public void updateUser(UsersDTO user, String name){

        Users updatedUser = usersRepository.findByName(name);
        updatedUser.setTitle(user.getTitle());
        updatedUser.setName(user.getName());
        usersRepository.save(updatedUser);

    }

}
