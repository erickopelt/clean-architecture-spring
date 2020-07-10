package io.opelt.cleanarchictecture.adapter.repository;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<UserEntity, String> {

    boolean existsById(String id);
}
