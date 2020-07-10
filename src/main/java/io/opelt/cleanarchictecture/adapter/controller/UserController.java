package io.opelt.cleanarchictecture.adapter.controller;

import io.opelt.cleanarchictecture.domain.User;
import io.opelt.cleanarchictecture.usecase.CreateUser;
import io.opelt.cleanarchictecture.usecase.DeleteUser;
import io.opelt.cleanarchictecture.usecase.FindUser;
import io.opelt.cleanarchictecture.usecase.UpdateUser;
import io.opelt.cleanarchictecture.usecase.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
class UserController {

    private CreateUser createUser;
    private FindUser findUser;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;

    UserController(CreateUser createUser, FindUser findUser, DeleteUser deleteUser, UpdateUser updateUser) {
        this.createUser = createUser;
        this.findUser = findUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> create(@RequestBody CreateUserDTO createUserDTO) {
        User createdUser = createUser.create(UserDTOMapper.to(createUserDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserDTOMapper.from(createdUser));
    }

    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> update(@PathVariable("id") String id,
                                           @RequestBody CreateUserDTO createUserDTO) {
        User createdUser = updateUser.update(UserDTOMapper.to(createUserDTO).setId(id));
        return ResponseEntity.status(HttpStatus.OK).body(UserDTOMapper.from(createdUser));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponseDTO> find(@PathVariable("id") String id) throws UserNotFoundException {
        return ResponseEntity.ok(UserDTOMapper.from(findUser.byId(id)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserResponseDTO>> find() {
        return ResponseEntity.ok(UserDTOMapper.from(findUser.all()));
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity delete(@PathVariable("id") String id) throws UserNotFoundException {
        User user = findUser.byId(id);
        deleteUser.delete(user);
        return ResponseEntity.noContent().build();
    }

}
