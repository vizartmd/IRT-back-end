package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.dto.TicketDTO;
import com.stefanini.irtbackend.domain.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);

    void delete(Ticket ticket);

    Ticket findById(Long id);

    void deleteById(Long id);

    List<Ticket> findAll();

    TicketDTO updateTicketStatus(Long id, String status);

    List<TicketDTO> fromListTicketToListTicketDTO(List<Ticket> ticket);
}
