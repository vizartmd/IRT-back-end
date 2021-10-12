package com.stefanini.irtbackend.entity;


import com.stefanini.irtbackend.entity.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role extends AbstractEntity implements GrantedAuthority {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "name")
    private RoleName name;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name + '\'' +
                '}';
    }

    public Role() {
    }

    public Role(RoleName name) {
        this.name = name;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
