package com.stefanini.irtbackend.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "role")
public class Role extends AbstractEntity implements GrantedAuthority {

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
//            mappedBy = "role",
            cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", users=" + users.stream().map(User::getId).collect(Collectors.toList()) +
                '}';
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
//        user.setRole(this);
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
