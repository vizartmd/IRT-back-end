package com.stefanini.irtbackend.domain.entity;

import com.stefanini.irtbackend.domain.entity.enums.RoleName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private RoleName role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_specialty")
    private SpecialtyName specialty;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;


    @OneToMany(mappedBy = "creator")
    private Set<Ticket> createdTickets = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "developer_ticket",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private Set<Ticket> processingTickets = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", specialty=" + specialty +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdTickets=" + createdTickets +
                ", processingTickets=" + processingTickets +
                '}';
    }

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SpecialtyName getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyName specialty) {
        this.specialty = specialty;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Ticket> getCreatedTickets() {
        return createdTickets;
    }

    public void setCreatedTickets(Set<Ticket> createdTickets) {
        this.createdTickets = createdTickets;
    }

    public Set<Ticket> getProcessingTickets() {
        return processingTickets;
    }

    public void setProcessingTickets(Set<Ticket> processingTickets) {
        this.processingTickets = processingTickets;
    }
}
