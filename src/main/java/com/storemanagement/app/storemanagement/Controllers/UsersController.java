package com.storemanagement.app.storemanagement.Controllers;

import com.storemanagement.app.storemanagement.APIErrors.NoSuchUsersExistsException;
import com.storemanagement.app.storemanagement.APIErrors.UserAlreadyExistsException;
import com.storemanagement.app.storemanagement.DTOs.UsersDTO;
import com.storemanagement.app.storemanagement.Entities.Users;
import com.storemanagement.app.storemanagement.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/name/{name}")
    public Users getUser(@PathVariable String name){
        return usersService.getUserByName(name);
    }

    @GetMapping(path = "/email/{email}")
    public Users getUserByEmail(@PathVariable String email){
        return usersService.getUserByEmail(email);
    }
    @ExceptionHandler(NoSuchUsersExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchUserFoundException(NoSuchUsersExistsException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @PostMapping(path = "/add")
    public void addUser(@RequestBody UsersDTO userDTO){
        usersService.addUser(userDTO);
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> handleUserExistsException(UserAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }
    @DeleteMapping(path = "/delete/{name}")
    public void deleteUser(@PathVariable String name){
        usersService.deleteUser(name);
    }

    @PutMapping(path = "/update/{name}")
    public void updateUser(@PathVariable String name, @RequestBody UsersDTO userDTO){
        usersService.updateUser(userDTO, name);
    }
}