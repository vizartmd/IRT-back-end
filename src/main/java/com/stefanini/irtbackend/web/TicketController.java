package com.stefanini.irtbackend.web;

import com.stefanini.irtbackend.domain.dto.TicketDTO;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.TicketService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLOutput;
import java.util.ArrayList;
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
    ResponseEntity<List<TicketDTO>> findAll() {
        return ResponseEntity.ok(ticketService.fromListTicketToListTicketDTO(ticketService.findAll()));
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
    ResponseEntity<TicketDTO> updateTicketStatus(@PathVariable("id") Long id, @PathVariable("status") String status) {
        System.out.println("in updateTicketStatus, id: " + id + " status: " + status);
        return ResponseEntity.ok(ticketService.updateTicketStatus(id, status));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
