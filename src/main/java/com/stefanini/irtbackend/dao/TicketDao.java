package com.stefanini.irtbackend.dao;

import com.stefanini.irtbackend.domain.entity.Ticket;

import java.util.List;

public interface TicketDao extends GenericDao<Ticket> {

    public List<Ticket> findAllTicketsFor(Long id);
}
