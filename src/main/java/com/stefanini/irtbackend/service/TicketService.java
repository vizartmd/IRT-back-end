package com.stefanini.irtbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stefanini.irtbackend.domain.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);

    void delete(Ticket ticket);

    Ticket findById(Long id);

    void deleteById(Long id);

    List<Ticket> findAll();

    String updateTicketStatus(Long id, String status) throws JsonProcessingException;

    String getListTicketDTO() throws JsonProcessingException;
}