package com.stefanini.irtbackend.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "role")
    private String role;

    @OneToMany(fetch = FetchType.LAZY,
                mappedBy = "role",
                cascade = CascadeType.ALL)
    private Set<User> users= new HashSet<>();

    public Role() {
    }

    public Role(Integer id, String role, Set<User> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
