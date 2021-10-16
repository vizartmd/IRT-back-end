package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.service.TicketService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
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
    @Transactional
    public Ticket findById(Long id) {
        return ticketDao.findById(id).orElseThrow(() -> new NotFoundException("Not found ticket with id = " + id));
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Ticket ticket = ticketDao.findById(id).orElseThrow(() -> new NotFoundException("Not found ticket with id = " + id));
        ticketDao.delete(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }

}
