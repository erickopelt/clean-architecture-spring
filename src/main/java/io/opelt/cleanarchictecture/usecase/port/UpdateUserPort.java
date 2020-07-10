package io.opelt.cleanarchictecture.usecase.port;

import io.opelt.cleanarchictecture.domain.User;

public interface UpdateUserPort {

    User update(User user);
}
