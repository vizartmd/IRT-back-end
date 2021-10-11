package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.entity.Ticket;
import com.stefanini.irtbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao){
        this.ticketDao = ticketDao;
    }

    @Transactional
    @Override
    public Ticket create(Ticket ticket) {
        return ticketDao.create(ticket);
    }

    @Transactional
    @Override
    public Ticket update(Ticket ticket) {
        return ticketDao.update(ticket);
    }

    @Transactional
    @Override
    public void delete(Ticket ticket) {
        ticketDao.delete(ticket);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        ticketDao.delete(findById(id));
    }

    @Override
    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }

}
