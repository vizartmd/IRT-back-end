package com.stefanini.irtbackend.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "creationDate")
    private LocalDate creationDate;

    @ManyToMany
    @JoinTable(name = "user_ticket", joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "ticketid"))
    private Set<Ticket> createdTickets = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "developer_ticket", joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "ticketid"))
    private Set<Ticket> processingTickets = new HashSet<>();

    public User() {
    }

    public User(Role role, Specialty specialty, String firstName, String lastName, String userName,
                Set<Ticket> createdTickets, Set<Ticket> processingTickets) {
        this.role = role;
        this.specialty = specialty;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.creationDate = LocalDate.now();
        this.createdTickets = createdTickets;
        this.processingTickets = processingTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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
