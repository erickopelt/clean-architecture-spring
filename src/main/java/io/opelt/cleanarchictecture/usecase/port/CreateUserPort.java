package io.opelt.cleanarchictecture.usecase.port;

import io.opelt.cleanarchictecture.domain.User;

public interface CreateUserPort {

    User createUser(User user);
}
