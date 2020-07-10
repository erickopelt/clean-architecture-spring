package io.opelt.cleanarchictecture.adapter.controller;

import java.io.Serializable;

class UserResponseDTO implements Serializable {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public UserResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
