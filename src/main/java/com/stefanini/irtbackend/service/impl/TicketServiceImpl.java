package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.dto.TicketDTO;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;
import com.stefanini.irtbackend.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Override
    public TicketDTO updateTicketStatus(Long id, String status) {
        Ticket ticket = findById(id);
        TicketDTO updatedTicket = new TicketDTO();
        updatedTicket.setCreatedDate(ticket.getCreatedDate().toString());
        updatedTicket.setId(ticket.getId().toString());
        updatedTicket.setTitle(ticket.getTitle());
        updatedTicket.setDescription(ticket.getDescription());
        updatedTicket.setSpecialty(ticket.getSpecialty().toString());
        updatedTicket.setStatus(status);
        updatedTicket.setPriority(ticket.getPriority().toString());
        updatedTicket.setCreator(ticket.getCreator().getUsername());
        updatedTicket.setDeveloper(ticket.getDeveloper().toString());
        switch (status) {
            case "BACKLOG":
                ticket.setStatus(StatusName.BACKLOG);
                break;
            case "ASIGNED":
                ticket.setStatus(StatusName.ASIGNED);
                break;
            case "FINISHED":
                ticket.setStatus(StatusName.FINISHED);
                break;
            case "CLOSED":
                ticket.setStatus(StatusName.CLOSED);
                break;
            default:
                break;
        }
        System.out.println("ticket: " + ticket.getCreator().getUsername());
        ticketDao.update(ticket);
        return updatedTicket;
    }

    @Override
    public List<TicketDTO> fromListTicketToListTicketDTO(List<Ticket> tickets) {
        List<TicketDTO> listTicketDTO = new ArrayList<>();
        for(int i = 0; i < tickets.size(); i++) {
            TicketDTO ticketDTO = new TicketDTO();
            ticketDTO.setCreatedDate(tickets.get(i).getCreatedDate().toString());
            ticketDTO.setId(tickets.get(i).getId().toString());
            ticketDTO.setTitle(tickets.get(i).getTitle());
            ticketDTO.setDescription(tickets.get(i).getDescription());
            ticketDTO.setSpecialty(tickets.get(i).getSpecialty().toString());
            ticketDTO.setStatus(tickets.get(i).getStatus().toString());
            ticketDTO.setPriority(tickets.get(i).getPriority().toString());
            ticketDTO.setCreator(tickets.get(i).getCreator().getUsername());
            String developer = null;
            if(tickets.get(i).getDeveloper() == null) {
                developer = "";
            } else {
                developer = tickets.get(i).getCreator().getUsername();
            }
            ticketDTO.setDeveloper(developer);
            ticketDTO.setDeveloper(tickets.get(i).getDeveloper().getUsername());
            listTicketDTO.add(ticketDTO);
        }
        return listTicketDTO;
    }

}
