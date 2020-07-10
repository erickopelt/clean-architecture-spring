package io.opelt.cleanarchictecture.usecase.port;

import io.opelt.cleanarchictecture.domain.User;

import java.util.List;
import java.util.Optional;

public interface FindUserPort {

    Optional<User> findById(String id);

    List<User> findAll();

}
