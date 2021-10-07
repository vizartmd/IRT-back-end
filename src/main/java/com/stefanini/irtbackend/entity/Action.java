package com.stefanini.irtbackend.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "action")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Priority priority;

    @ManyToOne
    private Status status;

    private LocalDate creationDate;
}
