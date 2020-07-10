package io.opelt.cleanarchictecture.adapter.repository;

import io.opelt.cleanarchictecture.domain.User;
import io.opelt.cleanarchictecture.usecase.port.CreateUserPort;
import io.opelt.cleanarchictecture.usecase.port.DeleteUserPort;
import io.opelt.cleanarchictecture.usecase.port.FindUserPort;
import io.opelt.cleanarchictecture.usecase.port.UpdateUserPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
class UserRepositoryGateway implements FindUserPort, CreateUserPort, DeleteUserPort, UpdateUserPort {

    private final UserRepository repository;

    public UserRepositoryGateway(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findById(String id) {
        return repository.findById(id).map(UserEntityMapper::to);
    }

    @Override
    public User createUser(User user) {
        return UserEntityMapper.to(repository.save(UserEntityMapper.from(user)));
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(userEntity -> users.add(UserEntityMapper.to(userEntity)));
        return users;
    }

    @Override
    public void delete(User user) {
        repository.delete(UserEntityMapper.from(user));
    }

    @Override
    public User update(User user) {
        return UserEntityMapper.to(repository.save(UserEntityMapper.from(user)));
    }
}
