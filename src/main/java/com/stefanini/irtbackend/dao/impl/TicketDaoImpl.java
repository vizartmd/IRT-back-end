package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.domain.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends GenericDaoImpl<Ticket> implements TicketDao {

    public TicketDaoImpl() {super(Ticket.class);}
}
