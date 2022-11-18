package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.APIErrors.NoSuchUsersExistsException;
import com.storemanagement.app.storemanagement.APIErrors.UserAlreadyExistsException;
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
            throw new NoSuchUsersExistsException("No user with name " + name );
        }
        else{
            logger.log(Level.INFO, "User with name " + name + " was found");
        }
        return user;
    }

    public Users getUserByEmail(String email){
        Users user = usersRepository.findByEmail(email);
        if(user == null){
            logger.log(Level.INFO, "User with email " + email +" wasn't found");
            throw new NoSuchUsersExistsException("No user with email " + email );
        }
        else{
            logger.log(Level.INFO, "User with email " + email + " was found");
        }
        return user;
    }

    public void addUser(UsersDTO usersDTO){
        Users userAlreadyExist = usersRepository.findByName(usersDTO.getName());
        if(userAlreadyExist != null){
            logger.log(Level.WARNING, "Couldn't add user with name " + userAlreadyExist.getName() + ", user already exists");
            throw new UserAlreadyExistsException("User already exists, please add another user");
        }

        try{
            Users user = Users.builder()
                    .title(usersDTO.getTitle())
                    .name(usersDTO.getName())
                    .password(usersDTO.getPassword())
                    .email(usersDTO.getEmail())
                    .build();
            if(usersDTO.getName() == null || usersDTO.getTitle() == null){
                logger.log(Level.WARNING, "POST Users: one or more elements was not assigned with a value and will be null");
            }
            usersRepository.save(user);
            logger.log(Level.INFO, "User with name "  + usersDTO.getName() + " was added");
        }
        catch (Exception e){
            logger.log(Level.INFO, "User with name " + usersDTO.getName() + " was not added");
        }
    }

    public void deleteUser(String name){
        Users user = usersRepository.findByName(name);

        if(user == null){
            logger.log(Level.INFO, "Couldn't delete user with name " + name +", user wasn't found");
            throw new NoSuchUsersExistsException("No user with name " + name);
        }
        else{
            usersRepository.delete(user);
            logger.log(Level.INFO, "User with name " + name + " was deleted");
        }
    }

    public void updateUser(UsersDTO user, String name){
        Users updateduser = usersRepository.findByName(name);

        if( user.getTitle() == null){
            updateduser.setTitle(updateduser.getTitle());
            logger.log(Level.INFO, "User with name " + name + " has no title included in the body so the value of the field will be the same");
        }
        else {
            updateduser.setTitle(user.getTitle());
        }
        if( user.getName() == null){
            updateduser.setName(updateduser.getName());
            logger.log(Level.INFO, "User with name " + name + " has no name included in the body so the value of the field will be the same");
        }
        else{
            updateduser.setName(user.getName());
        }
        if( user.getName() == null){
            updateduser.setPassword(updateduser.getPassword());
            logger.log(Level.INFO, "User with name " + name + " has no password included in the body so the value of the field will be the same");
        }
        else{
            updateduser.setPassword(user.getPassword());
        }

        if( user.getName() == null){
            updateduser.setEmail(updateduser.getEmail());
            logger.log(Level.INFO, "User with name " + name + " has no email included in the body so the value of the field will be the same");
        }
        else{
            updateduser.setEmail(user.getEmail());
        }

        usersRepository.save(updateduser);
        logger.log(Level.INFO, "User with name " + name + " was updated");

    }

}