package com.stefanini.irtbackend.security;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.stefanini.irtbackend.security.UserPermission.*;


public enum UserRole {

    USER(Sets.newHashSet(USER_READ)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

//    USER(Sets.newHashSet(TICKET_CREATE, TICKET_LEAVE_COMMENT, USER_SELF_MODIFY)),
//    DEVELOPER(Sets.newHashSet(TICKET_CREATE, TICKET_MODIFY, TICKET_LEAVE_COMMENT, USER_SELF_MODIFY)),
//    ADMIN(Sets.newHashSet(TICKET_CREATE, TICKET_MODIFY, TICKET_LEAVE_COMMENT, TICKET_DELETE,
//                          USER_CREATE, USER_MODIFY, USER_DELETE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    @Bean
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
