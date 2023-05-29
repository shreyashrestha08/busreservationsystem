package com.blume.busbackend.controller;

import com.blume.busbackend.Beans.UserBean;

import com.blume.busbackend.models.User;
import com.blume.busbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;
    @PostMapping("/add")
    User create(@RequestBody User user) {
//        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("User : " + user);
        return userService.create(user);
    }

    @GetMapping("/all")
    List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/find/{email}/{password}")
    User  findinguser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.findone(email, password);
    }

    @GetMapping("/find/{email}/{password}/{role}")
    User  findingrole(@PathVariable("email") String email, @PathVariable("password") String password, @PathVariable("role") String role) {
        return userService.findrole(email, password,role);
    }

    @DeleteMapping("/delete/{email}")
    String  deleteId(@PathVariable("email") String email) {
        userService.delete(email);
        return "Successfully Deleted!" + email;
    }
    @GetMapping("/find/{email}")
    User findId(@PathVariable("email") String email) {
        return  userService.find(email);
    }


    //login verification
    @GetMapping ("/login/{email}/{password}")
    User loginHandler(@PathVariable("email") String email, @PathVariable("password") String password) {
        User user = userService.findone(email, password);
        if(Objects.equals(user.getPassword(), password) && Objects.equals(user.getEmail(), email)){
            return user;
        }
        else{
            return null;
        }

    }

    @GetMapping ("/login/{email}/{password}/{role}")
    User adminloginHandler(@PathVariable("email") String email, @PathVariable("password") String password,  @PathVariable("role") String role) {
        User user = userService.findrole(email, password, role);
        if (Objects.equals(user.getPassword(), password) && Objects.equals(user.getEmail(), email) && Objects.equals(user.getRole(), role)) {
            return user;
        }
        else {
            return null;
        }


    }
}
