package org.example.fines_api.mapper;

import org.example.fines_api.dto.user.UserDto;
import org.example.fines_api.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPhoneNumber(),
                user.getBirthDate(),
                user.getLogin(),
                user.getPassword(),
                user.getLicense()
        );
    }

    public static List<UserDto> toDto(List<User> fines) {
        return fines.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    public static User toEntity(UserDto dto) {
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getBirthDate(),
                dto.getLogin(),
                dto.getPassword(),
                dto.getLicense(),
                List.of(),
                List.of(),
                List.of()
        );
    }
}
