package io.opelt.cleanarchictecture.usecase;

import io.opelt.cleanarchictecture.domain.User;
import io.opelt.cleanarchictecture.usecase.port.UpdateUserPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateUser {

    private UpdateUserPort updateUserPort;

    public UpdateUser(UpdateUserPort updateUserPort) {
        this.updateUserPort = updateUserPort;
    }

    public User update(User user) {
        return updateUserPort.update(user);
    }
}
