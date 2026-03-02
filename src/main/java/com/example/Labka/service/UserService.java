package com.example.Labka.service;

import com.example.Labka.dto.LoginRequest;
import com.example.Labka.dto.RegisterRequest;
import com.example.Labka.dto.LoginResponse;
import com.example.Labka.entity.User;
import com.example.Labka.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ================== REGISTRATION ==================
    public User registerUser(RegisterRequest request) throws Exception {
        Optional<User> existing = userRepository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            throw new Exception("Email уже используется");
        }

        User user = new User(
                request.getName(),
                request.getFaculty(),
                request.getEmail(),
                request.getPassword(), // пока без шифрования
                request.getRole()
        );

        return userRepository.save(user);
    }

    // ================== LOGIN ==================
    public LoginResponse loginUser(LoginRequest request) throws Exception {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            throw new Exception("Пользователь не найден");
        }

        User user = userOpt.get();
        if (!user.getPasswordHash().equals(request.getPassword())) {
            throw new Exception("Неверный пароль");
        }

        return new LoginResponse(
                user.getUserId(),
                user.getName(),
                user.getRole()
        );
    }
}
