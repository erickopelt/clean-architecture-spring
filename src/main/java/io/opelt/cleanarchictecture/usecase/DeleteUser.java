package io.opelt.cleanarchictecture.usecase;

import io.opelt.cleanarchictecture.domain.User;
import io.opelt.cleanarchictecture.usecase.port.DeleteUserPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser {

    private DeleteUserPort deleteUserPort;

    public DeleteUser(DeleteUserPort deleteUserPort) {
        this.deleteUserPort = deleteUserPort;
    }

    public void delete(User user) {
        deleteUserPort.delete(user);
    }
}
