package io.opelt.cleanarchictecture.adapter.controller;

import java.io.Serializable;

class CreateUserDTO implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    CreateUserDTO setName(String name) {
        this.name = name;
        return this;
    }
}
