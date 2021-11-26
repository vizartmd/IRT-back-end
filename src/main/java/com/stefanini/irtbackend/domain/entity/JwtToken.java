package com.stefanini.irtbackend.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "jwt_token")
public class JwtToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "counter")
    private Long counter;

    public JwtToken() {
    }

    public JwtToken(int id, Long counter) {
        this.id = id;
        this.counter = counter;
    }

    public JwtToken(Long counter) {
        this.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "JwtToken{" +
                "id=" + id +
                ", counter=" + counter +
                '}';
    }
}
