package io.opelt.cleanarchictecture.adapter.controller;

import io.opelt.cleanarchictecture.domain.User;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

final class UserDTOMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private UserDTOMapper() {
    }

    static User to(CreateUserDTO dto) {
        return mapper.map(dto, User.class);
    }

    static UserResponseDTO from(User user) {
        return mapper.map(user, UserResponseDTO.class);
    }

    static List<UserResponseDTO> from(List<User> users) {
        return users.stream().map(UserDTOMapper::from).collect(Collectors.toList());
    }
}
