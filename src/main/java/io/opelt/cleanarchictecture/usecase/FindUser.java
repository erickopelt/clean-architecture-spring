package io.opelt.cleanarchictecture.usecase;

import io.opelt.cleanarchictecture.domain.User;
import io.opelt.cleanarchictecture.usecase.exception.UserNotFoundException;
import io.opelt.cleanarchictecture.usecase.port.FindUserPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindUser {

    private final FindUserPort findUserPort;

    public FindUser(FindUserPort findUserPort) {
        this.findUserPort = findUserPort;
    }

    public User byId(String id) throws UserNotFoundException {
        return findUserPort.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<User> all() {
        return findUserPort.findAll();
    }
}
