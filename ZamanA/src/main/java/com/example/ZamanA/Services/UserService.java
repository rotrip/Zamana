package com.example.ZamanA.Services;

import com.example.ZamanA.Controllers.UserController;
import com.example.ZamanA.Models.User;
import com.example.ZamanA.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;
    public User loginUser(String email, String password) {
        User user=userRepository.findByEmail(email);
        if(user!=null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
