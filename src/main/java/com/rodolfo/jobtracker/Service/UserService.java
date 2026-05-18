package com.rodolfo.jobtracker.Service;


import com.rodolfo.jobtracker.DTO.UpdatePasswordDTO;
import com.rodolfo.jobtracker.DTO.UserProfileDTO;
import com.rodolfo.jobtracker.Entity.User;
import com.rodolfo.jobtracker.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserProfileDTO getUserProfile(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return new UserProfileDTO(user.getId(), user.getEmail(), user.getName());
    }

    public void updateProfile(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow();
        if(user.getEmail() != null){
            existingUser.setEmail(user.getEmail());
        }
        if(user.getName() != null){
            existingUser.setName(user.getName());
        }

        userRepository.save(existingUser);
    }

    public void updatePassword(Long id, UpdatePasswordDTO updatePasswordDTO) {
        User existingUser = userRepository.findById(id).orElseThrow();
        existingUser.setPassword(updatePasswordDTO.getPassword());
        userRepository.save(existingUser);
    }
}
