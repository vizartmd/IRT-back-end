package com.stefanini.irtbackend.model;

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

    private Priority priority;

    private LocalDate creationDate;

}
