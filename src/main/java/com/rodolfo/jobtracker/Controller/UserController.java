package com.rodolfo.jobtracker.Controller;

import com.rodolfo.jobtracker.DTO.UpdatePasswordDTO;
import com.rodolfo.jobtracker.DTO.UserProfileDTO;
import com.rodolfo.jobtracker.Entity.User;
import com.rodolfo.jobtracker.Service.UserService;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/api/v1/users/{id}")
    public UserProfileDTO getUserProfile(@PathVariable Long id){
        return userService.getUserProfile(id);
    }

    @PatchMapping("/api/v1/users/{id}")
    public void updateProfile(@PathVariable Long id, @RequestBody User user){
        userService.updateProfile(id, user);
    }

    @PatchMapping("/api/v1/users/{id}/password")
    public void updatePassword(@PathVariable Long id, @RequestBody UpdatePasswordDTO updatePasswordDTO){
        userService.updatePassword(id,updatePasswordDTO);
    }




}
