package io.opelt.cleanarchictecture.usecase;

import io.opelt.cleanarchictecture.domain.User;
import io.opelt.cleanarchictecture.usecase.port.CreateUserPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

    private CreateUserPort createUserPort;

    private FindUser findUser;

    public CreateUser(CreateUserPort createUserPort, FindUser findUser) {
        this.createUserPort = createUserPort;
        this.findUser = findUser;
    }

    public User create(User user) {
        return createUserPort.createUser(user);
    }
}
