package io.opelt.cleanarchictecture.adapter.repository;

import io.opelt.cleanarchictecture.domain.User;
import org.modelmapper.ModelMapper;

final class UserEntityMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private UserEntityMapper() {
    }

    static UserEntity from(User user) {
        return mapper.map(user, UserEntity.class);
    }

    static User to(UserEntity user) {
        return mapper.map(user, User.class);
    }
}
