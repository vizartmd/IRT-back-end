package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.entity.Ticket;
import com.stefanini.irtbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;

    @Autowired
    public TicketServiceImpl(TicketDao ticketDao){
        this.ticketDao = ticketDao;
    }

    @Override
    public boolean create(Ticket ticket) {
        return ticketDao.create(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return ticketDao.update(ticket);
    }

    @Override
    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        ticketDao.delete(findById(id));
    }

    @Override
    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }

    @Override
    public void assignTicket(Long userId, Long ticketId) {
        //to be implemented
    }
}
