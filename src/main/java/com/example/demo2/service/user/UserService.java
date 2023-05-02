package com.example.demo2.service.user;

import com.example.demo2.domain.user.User;
import com.example.demo2.dto.request.UserCreateRequest;
import com.example.demo2.dto.request.UserUpdateRequest;
import com.example.demo2.dto.response.UserResponse;
import com.example.demo2.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));
    }
    public void deleteUser(String name) {
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }
    public List<UserResponse> getUsers(){
        return userRepository.findAll().stream()
                .map(user->new UserResponse(user.getId(), user.getName(), user.getAge())).collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(IllegalArgumentException::new);
        user.setName(request.getName());
        userRepository.save(user);
    }
}
