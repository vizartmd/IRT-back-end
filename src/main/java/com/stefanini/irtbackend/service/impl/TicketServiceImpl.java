package com.stefanini.irtbackend.service.impl;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.dto.TicketDto;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;
import com.stefanini.irtbackend.service.TicketService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;
    private final UserDao userDao;

    public TicketServiceImpl(TicketDao ticketDao, UserDao userDao) {
        this.ticketDao = ticketDao;
        this.userDao = userDao;
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
    public List<TicketDto> updateTicketStatus(Long id, String status) {
        Ticket ticket = findById(id);
        switch (status) {
            case "BACKLOG":
                ticket.setStatus(StatusName.BACKLOG);
                break;
            case "ASSIGNED":
                ticket.setStatus(StatusName.ASSIGNED);
                break;
            case "FINISHED":
                ticket.setStatus(StatusName.FINISHED);
                break;
            case "CLOSED":
                ticket.setStatus(StatusName.CLOSED);
                ticket.setClosedDate(LocalDate.now());
                break;
            default:
                ticketDao.update(ticket);
        }
        return getListTicketDTO();
    }

    @Override
    public List<TicketDto> getListTicketDTO() {
        List<Ticket> tickets = ticketDao.findAll();
        List<TicketDto> listTicketDto = new ArrayList<>();
        for(int i = 0; i < tickets.size(); i++) {
            TicketDto ticketDTO = new TicketDto();
            ticketDTO.setCreatedDate(tickets.get(i).getCreatedDate().toString());
            if (tickets.get(i).getClosedDate() != null){
                ticketDTO.setClosedDate(tickets.get(i).getClosedDate().toString());
            }
            //ticketDTO.setClosedDate(tickets.get(i).getClosedDate().toString());
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
                developer = tickets.get(i).getDeveloper().getUsername();
            }
            ticketDTO.setDeveloper(developer);
            listTicketDto.add(ticketDTO);
        }
        return listTicketDto;
    }

    @Override
    public Ticket createTicketFromDTO(TicketDto ticketDto) throws ParseException {
       Ticket ticket = new Ticket();

       ticket.setTitle(ticketDto.getTitle());
       ticket.setDescription((ticketDto.getDescription()));
       ticket.setStatus(StatusName.valueOf(ticketDto.getStatus()));
       ticket.setPriority(PriorityName.valueOf(ticketDto.getPriority()));
       ticket.setSpecialty(SpecialtyName.valueOf(ticketDto.getSpecialty()));
       ticket.setCreator(userDao.findByUsername(ticketDto.getCreator()));
       ticket.setDeveloper(userDao.findByUsername(ticketDto.getDeveloper()));
       return ticketDao.create(ticket);
    }

}
