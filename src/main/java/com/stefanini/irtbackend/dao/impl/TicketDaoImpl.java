package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.domain.entity.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TicketDaoImpl extends GenericDaoImpl<Ticket> implements TicketDao {

    public TicketDaoImpl() {
        super(Ticket.class);
    }


    public List<Ticket> findAllTicketsFor(Long id) {
        List<Ticket> tickets = findAll();
        tickets = tickets.stream().filter(ticket -> ticket.getDeveloper().getId().equals(id)).collect(Collectors.toList());
        return tickets;
    }
}
