package org.example.fines_api.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.fines_api.entity.User;
import org.example.fines_api.error.ResourceNotFoundException;
import org.example.fines_api.repository.UserRepository;
import org.example.fines_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id %d not found.".formatted(userId)));
    }

    @Override
    public User updateUser(User user) {
        User dbUser = getUserById(user.getId());
        dbUser.setBirthDate(user.getBirthDate());
        dbUser.setLogin(user.getLogin());
        dbUser.setUsername(user.getUsername());
        dbUser.setPassword(user.getPassword());
        dbUser.setLicense(user.getLicense());
        dbUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.flush();
        return user;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }
}
