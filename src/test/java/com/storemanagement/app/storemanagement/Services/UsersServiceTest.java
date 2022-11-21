package com.storemanagement.app.storemanagement.Services;

import com.storemanagement.app.storemanagement.DTOs.UsersDTO;
import com.storemanagement.app.storemanagement.Entities.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersServiceTest {
    @Autowired
    UsersService usersService;

    @Test
    public void findByNameTest(){
        String name = "catalina_matei";
        Users users = usersService.getUserByName(name);
        assertEquals("administrator", users.getTitle());
        assertEquals(name, users.getName());
        assertEquals("catalina@gmail.com", users.getEmail());
        assertEquals("parola", users.getPassword());
    }

    @Test
    public void findByEmailTest(){
        String email = "catalina@gmail.com";
        Users users = usersService.getUserByEmail(email);
        assertEquals("administrator", users.getTitle());
        assertEquals("catalina_matei", users.getName());
        assertEquals(email, users.getEmail());
        assertEquals("parola", users.getPassword());
    }

    @Test
    void addUserTest() throws Exception {
        String name = "popescu_lucian";
        UsersDTO usersDTO = new UsersDTO("admin", name, "luci.pop@gmail.com", "parola123");
        usersService.addUser(usersDTO);
        assertEquals( name, usersService.getUserByName(name).getName());
        assertEquals("admin", usersService.getUserByName(name).getTitle());
        assertEquals("luci.pop@gmail.com", usersService.getUserByName(name).getEmail());
        assertEquals("parola123", usersService.getUserByName(name).getPassword());
    }

    @Test
    void updateUserTest() throws Exception{
        String name = "catalina.matei";
        UsersDTO usersDTO = new UsersDTO("admin", name, "cata@gmail.com", "parolamea");
        usersService.updateUser(usersDTO, name);
        assertEquals( name, usersService.getUserByName(name).getName());
        assertEquals("admin", usersService.getUserByName(name).getTitle());
        assertEquals("cata@gmail.com", usersService.getUserByName(name).getEmail());
        assertEquals("parolamea", usersService.getUserByName(name).getPassword());
    }
}