package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.DTOs.UsersDTO;
import com.storemanagement.app.storemanagement.Entities.Users;
import com.storemanagement.app.storemanagement.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;
    Logger logger = Logger.getLogger(UsersService.class.getName());
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users getUserByName(String name){
        Users user = usersRepository.findByName(name);
        if(user == null){
            logger.log(Level.INFO, "User with name " + name +" wasn't found");
        }
        else{
            logger.log(Level.INFO, "User with name " + name + " was found");
        }
        return user;
    }

    public void addUser(UsersDTO usersDTO){
        try{
            Users user = Users.builder()
                    .title(usersDTO.getTitle())
                    .name(usersDTO.getName())
                    .build();
            if(usersDTO.getName() == null || usersDTO.getTitle() == null){
                logger.log(Level.WARNING, "POST Users: one or more elements was not assigned with a value and will be null");
            }
            usersRepository.save(user);
            logger.log(Level.INFO, "User was added");
        }
        catch (Exception e){
            logger.log(Level.INFO, "User was not added");
        }
    }

    public void deleteUser(String name){
        Users user = usersRepository.findByName(name);

        if(user == null){
            logger.log(Level.INFO, "User with name " + name +" wasn't found");
        }
        else{
            usersRepository.delete(user);
            logger.log(Level.INFO, "User with name " + name + " was deleted");
        }
    }

    public void updateUser(UsersDTO user, String name){

        Users updatedUser = usersRepository.findByName(name);
        updatedUser.setTitle(user.getTitle());
        updatedUser.setName(user.getName());
        usersRepository.save(updatedUser);

    }

}
