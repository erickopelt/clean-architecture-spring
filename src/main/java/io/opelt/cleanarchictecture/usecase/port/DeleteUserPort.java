package io.opelt.cleanarchictecture.usecase.port;

import io.opelt.cleanarchictecture.domain.User;

public interface DeleteUserPort {

    void delete(User user);
}
