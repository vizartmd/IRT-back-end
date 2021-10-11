package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.entity.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends GenericDaoImpl<Ticket> implements TicketDao {

    TicketDaoImpl() {
        super(Ticket.class);
    }
}
