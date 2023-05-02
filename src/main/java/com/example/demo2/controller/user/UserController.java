package com.example.demo2.controller.user;

import com.example.demo2.dto.request.UserCreateRequest;
import com.example.demo2.dto.request.UserUpdateRequest;
import com.example.demo2.dto.response.UserResponse;
import com.example.demo2.service.user.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService=userService;
    }
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    };
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) { userService.updateUser(request); }
}
