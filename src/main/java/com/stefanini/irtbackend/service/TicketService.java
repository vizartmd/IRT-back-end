package com.stefanini.irtbackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.stefanini.irtbackend.domain.dto.TicketDto;

import com.stefanini.irtbackend.domain.entity.Ticket;

import java.text.ParseException;
import java.util.List;

public interface TicketService {

    Ticket create(Ticket ticket);

    Ticket update(Ticket ticket);

    Ticket updateWithDto(TicketDto ticketDto);

    void delete(Ticket ticket);

    Ticket findById(Long id);


    Boolean existTicketWithTitle(String title);

    String findDtoById(Long id) throws JsonProcessingException;

    void deleteById(Long id);

    List<Ticket> findAll();

    Ticket createTicketFromDTO(TicketDto ticketDto) throws ParseException;

    String updateTicketStatus(Long id, String status) throws JsonProcessingException;

    String getListTicketDTO() throws JsonProcessingException;

    String updateTicketDeveloper(Long id, String developer) throws JsonProcessingException;

    List<Ticket> getTicketFor(Long id);

}

