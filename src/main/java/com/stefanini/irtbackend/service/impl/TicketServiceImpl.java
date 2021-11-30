package com.stefanini.irtbackend.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.dto.TicketDto;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;
import com.stefanini.irtbackend.service.TicketService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class TicketServiceImpl implements TicketService {

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

    @Override
    public Ticket updateWithDto(TicketDto ticketDto) {
        Long id = Long.parseLong(ticketDto.getId());
        Ticket ticket = findById(id);

        if (!ticketDto.getDeveloper().equals("NOT SET")) {
            User user = userDao.findByUsername(ticketDto.getDeveloper());
            ticket.setDeveloper(user);
        } else {
            ticket.setDeveloper(null);
        }

        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setPriority(PriorityName.valueOf(ticketDto.getPriority()));
        ticket.setStatus(StatusName.valueOf(ticketDto.getStatus()));
        ticket.setSpecialty(SpecialtyName.valueOf(ticketDto.getSpecialty()));

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

    @Override
    public Boolean existTicketWithTitle(String title) {
        return ticketDao.existTicketWithTitle(title);
    }

    @Override
    public String findDtoById(Long id) throws JsonProcessingException {
        TicketDto ticketDto = new TicketDto();
        Ticket ticket = findById(id);

        ticketDto.setCreatedDate(ticket.getCreatedDate().toString());
        if (ticket.getClosedDate() != null) {
            ticketDto.setClosedDate(ticket.getClosedDate().toString());
        }
        ticketDto.setId(ticket.getId().toString());
        ticketDto.setTitle(ticket.getTitle());
        ticketDto.setDescription(ticket.getDescription());
        ticketDto.setSpecialty(ticket.getSpecialty().toString());
        ticketDto.setStatus(ticket.getStatus().toString());
        ticketDto.setPriority(ticket.getPriority().toString());
        ticketDto.setCreator(ticket.getCreator().getUsername());
        if (ticket.getDeveloper() != null) {
            ticketDto.setDeveloper(ticket.getDeveloper().getUsername());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(ticketDto);

    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Ticket ticket = ticketDao.findById(id).orElseThrow(() -> new NotFoundException("Not found ticket with id = " + id));
        ticketDao.delete(ticket);
    }

    @Override
    @Transactional
    public List<Ticket> getTicketFor(Long id) {
        return ticketDao.findAllTicketsFor(id);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketDao.findAll();
    }

    @Override
    public String updateTicketStatus(Long id, String status) throws JsonProcessingException {
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
    public String getListTicketDTO() throws JsonProcessingException {
        List<Ticket> tickets = ticketDao.findAll();
        List<TicketDto> listTicketDto = new ArrayList<>();
        for (Ticket ticket : tickets) {
            TicketDto ticketDTO = new TicketDto();

            ticketDTO.setCreatedDate(ticket.getCreatedDate().toString());
            if (ticket.getClosedDate() != null) {
                ticketDTO.setClosedDate(ticket.getClosedDate().toString());
            }
            ticketDTO.setId(ticket.getId().toString());
            ticketDTO.setTitle(ticket.getTitle());
            ticketDTO.setDescription(ticket.getDescription());
            ticketDTO.setSpecialty(ticket.getSpecialty().toString());
            ticketDTO.setStatus(ticket.getStatus().toString());
            ticketDTO.setPriority(ticket.getPriority().toString());
            ticketDTO.setCreator(ticket.getCreator().getUsername());
            if (ticket.getDeveloper() != null) {
                ticketDTO.setDeveloper(ticket.getDeveloper().getUsername());
            }
            listTicketDto.add(ticketDTO);

        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(listTicketDto);
    }

    @Override
    public String updateTicketDeveloper(Long id, String developer) throws JsonProcessingException {
        Ticket ticket = findById(id);
        List<User> users = userDao.findAll();
        User user = users.stream().filter(u -> u.getUsername().equals(developer)).findFirst().orElse(null);
        if (user != null && ticket != null) {
            user.getProcessingTickets().add(ticket);
            ticket.setDeveloper(user);
        }
        userDao.update(user);
        ticketDao.update(ticket);
        return getListTicketDTO();
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
        if (ticketDto.getDeveloper() != null) {
            ticket.setDeveloper(userDao.findByUsername(ticketDto.getDeveloper()));
        }
        return ticketDao.create(ticket);
    }

}