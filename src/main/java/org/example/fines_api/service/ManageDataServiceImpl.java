package org.example.fines_api.service;

import org.example.fines_api.entity.User;
import org.example.fines_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageDataServiceImpl implements ManageDataService {

    private final UserRepository userRepository;

    public ManageDataServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
