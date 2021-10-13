package com.stefanini.irtbackend.entity.enums;

public enum RoleName {
    ADMIN(0),
    DEVELOPER(1);

    private final int value;

    RoleName(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
