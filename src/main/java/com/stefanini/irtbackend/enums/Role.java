package com.stefanini.irtbackend.enums;

public enum Role {
    ADMIN(1), DEVELOPER(2);

    private int numVal;

    Role(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}
