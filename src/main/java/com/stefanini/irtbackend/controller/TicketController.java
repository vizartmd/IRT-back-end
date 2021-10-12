package com.stefanini.irtbackend.controller;

import com.stefanini.irtbackend.entity.Ticket;
import com.stefanini.irtbackend.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    ResponseEntity<List<Ticket>> findAll() {
        return ResponseEntity.ok(ticketService.findAll());
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
        return ResponseEntity.ok(ticketService.update(ticket));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
