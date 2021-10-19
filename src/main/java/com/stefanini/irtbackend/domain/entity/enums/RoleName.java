package com.stefanini.irtbackend.domain.entity.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleName {
    USER(new HashSet<>(Collections.singletonList(Permission.USERS_READ))),
    ADMIN(new HashSet<>(Arrays.asList(Permission.USERS_READ, Permission.USERS_WRITE)));

    private final Set<Permission> permissions;

    RoleName(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
