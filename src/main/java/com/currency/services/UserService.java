package com.currency.services;

import com.currency.dto.UserDTO;
import com.currency.mapper.UserDTOMapper;
import com.currency.models.User;
import com.currency.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public Optional<User> getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = false)
    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}