package com.stefanini.irtbackend.security;

public enum UserPermission {
    TICKET_CREATE("ticket:create"),
    TICKET_MODIFY("ticket:modify"),
    TICKET_LEAVE_COMMENT("ticket:leave_comment"),
    TICKET_DELETE("ticket:delete"),
    USER_CREATE("user:create"),
    USER_MODIFY("user:modify"),
    USER_SELF_MODIFY("user:self_modify"),
    USER_DELETE("user:delete");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
