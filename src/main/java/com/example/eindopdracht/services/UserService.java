package com.example.eindopdracht.services;

import com.example.eindopdracht.dto.PropertyDto;
import com.example.eindopdracht.dto.UserDto;
import com.example.eindopdracht.exceptions.IdNotFoundException;
import com.example.eindopdracht.models.Property;
import com.example.eindopdracht.models.User;
import com.example.eindopdracht.repositories.PropertyRepository;
import com.example.eindopdracht.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User u : users) {
            UserDto uDto = new UserDto();
            userToUserDto(u, uDto);

            userDtos.add(uDto);
        }
        return userDtos;
    }

    private static void userToUserDto(User u, UserDto uDto) {
        uDto.setId(u.getId());
        uDto.setUsername(u.getUsername());
        uDto.setPassword(u.getPassword());
    }

    private void userDtoToUser(UserDto userDto, User user) {
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
    }

    public UserDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User u = user.get();
            UserDto uDto = new UserDto();
            userToUserDto(u, uDto);
            return (uDto);
        } else {
            throw new IdNotFoundException("Property not found with ID: " + id);
        }
    }


    public UserDto createUser(UserDto userDto) {
        User user = new User();
        userDtoToUser(userDto, user);

        User savedUser = userRepository.save(user);

        UserDto savedUserDto = new UserDto();
       userToUserDto(savedUser, savedUserDto);

        return savedUserDto;
    }

    public void deleteUser(@RequestBody Long id) {
        userRepository.deleteById(id);
    }
}
