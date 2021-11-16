package com.stefanini.irtbackend.service;

import com.stefanini.irtbackend.domain.dto.TicketDto;
import com.stefanini.irtbackend.domain.entity.Ticket;

import java.text.ParseException;
import java.util.List;

public interface TicketService {
    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);

    void delete(Ticket ticket);

    Ticket findById(Long id);

    void deleteById(Long id);

    List<Ticket> findAll();

    List<TicketDto> updateTicketStatus(Long id, String status);

    List<TicketDto> getListTicketDTO();

    Ticket createTicketFromDTO(TicketDto ticketDto) throws ParseException;
}
