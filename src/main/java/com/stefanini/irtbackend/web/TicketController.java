package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.domain.dto.TicketDto;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.TicketService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.LocaleData;

import java.net.URI;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final UserService userService;

    public TicketController(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<List<TicketDto>> findAll() {
        return ResponseEntity.ok(ticketService.getListTicketDTO());
    }

    @GetMapping("/{id}")
    ResponseEntity<Ticket> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @PostMapping("/{creator_id}/{developer_id}")
    ResponseEntity<Ticket> create(@RequestBody Ticket ticket, @PathVariable(value = "creator_id") Long creator_id, @PathVariable(value = "developer_id") Long developer_id ) {
        User creator_user = userService.findById(creator_id);
        User developer_user = userService.findById(developer_id);
        ticket.setCreator(creator_user);
        ticket.setDeveloper(developer_user);//dto or service
        Ticket createdTicket = ticketService.create(ticket);
        return ResponseEntity.created(URI.create("/tickets/" + createdTicket.getId())).body(createdTicket);
    }

    @PutMapping
    ResponseEntity<Ticket> update(@RequestBody Ticket ticket) {
        System.out.println("ticket: " + ticket);
        return ResponseEntity.ok(ticketService.update(ticket));
    }

    @PutMapping("/{id}/{status}")
    ResponseEntity<List<TicketDto>> updateTicketStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
        System.out.println("in updateTicketStatus, id: " + id + " status: " + status);
        return ResponseEntity.ok(ticketService.updateTicketStatus(id, status));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
