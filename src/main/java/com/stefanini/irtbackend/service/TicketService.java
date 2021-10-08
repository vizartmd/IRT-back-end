package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);

    void delete(Ticket ticket);

    Ticket findById(Long id);

    void deleteById(Long id);

    List<Ticket> findAll();

    void assignTicket(Long userId, Long ticketId);
}
