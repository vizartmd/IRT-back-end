package com.stefanini.irtbackend.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.service.TicketService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
    String findAll() throws JsonProcessingException {
        return ticketService.getListTicketDTO();
    }

    @GetMapping("/kanban")
    String findAllTickets() throws JsonProcessingException {
        return ticketService.getListTicketDTO();
    }

    @GetMapping("/{id}")
    ResponseEntity<Ticket> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @PostMapping
    ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        Ticket createdTicket = ticketService.create(ticket);
        return ResponseEntity.created(URI.create("/tickets/" + createdTicket.getId())).body(createdTicket);
    }

    @PutMapping
    ResponseEntity<Ticket> update(@RequestBody Ticket ticket) {
        System.out.println("ticket: " + ticket);
        return ResponseEntity.ok(ticketService.update(ticket));
    }

    @PutMapping("/{id}/{status}")
    String updateTicketStatus(@PathVariable("id") Long id, @PathVariable("status") String status) throws JsonProcessingException {
        System.out.println("in updateTicketStatus, id: " + id + " status: " + status);
        return ticketService.updateTicketStatus(id, status);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}