package com.example.ZamanA.Controllers;


import com.example.ZamanA.Models.User;
import com.example.ZamanA.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        User RegisteredUser=userService.registerUser(user);
        return ResponseEntity.ok(RegisteredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        User loggedInUser=userService.loginUser(user.getEmail(),user.getPassword());
        if(loggedInUser!=null){
            return ResponseEntity.ok(loggedInUser);
        }
        else{
            return ResponseEntity.status(401).body("Invalid Credentials");
        }

    }
}
