package com.stefanini.irtbackend.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stefanini.irtbackend.domain.dto.TicketDto;
import com.stefanini.irtbackend.domain.dto.UserDto;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;
import com.stefanini.irtbackend.service.TicketService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

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
    List<Ticket> findAll() {
        return ticketService.findAll();
    }


    @GetMapping("/{id}")
    ResponseEntity<Ticket> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @GetMapping("/exist-title/{title}")
    ResponseEntity<Boolean> existTicketWithTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(ticketService.existTicketWithTitle(title));
    }


    @GetMapping("/user-tickets/{developer_id}")
    ResponseEntity<List<Ticket>> findTicketsFor(@PathVariable("developer_id") Long id) {
        return ResponseEntity.ok(ticketService.getTicketFor(id));
    }

    @GetMapping("/kanban")
    String findAllTickets() throws JsonProcessingException {
        return ticketService.getListTicketDTO();
    }


    @PostMapping
    ResponseEntity<Ticket> create(@RequestBody TicketDto ticketDto) throws ParseException {
        Ticket createdTicket = ticketService.createTicketFromDTO(ticketDto);
        return ResponseEntity.created(URI.create("/tickets/" + createdTicket.getId())).body(createdTicket);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@RequestBody TicketDto ticketDto) {
        Ticket ticket = null;
        try {
            System.out.println("11111111111");

            ticket = (ticketService.updateWithDto(ticketDto));
            System.out.println("22222222222");
            return ResponseEntity.ok(ticket);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Duplicate entry");
        }
    }

    @PutMapping("/{id}/{status}")
    String updateTicketStatus(@PathVariable("id") Long id, @PathVariable("status") String status) throws JsonProcessingException {
        System.out.println("in updateTicketStatus, id: " + id + " status: " + status);
        return ticketService.updateTicketStatus(id, status);
    }
    @PutMapping("/add/{id}/{developer}")
    String updateTicketDeveloper(@PathVariable("id") Long id, @PathVariable("developer") String developer) throws JsonProcessingException {
        System.out.println("in updateTicketDeveloper, id: " + id + " developer: " + developer);
        return ticketService.updateTicketDeveloper(id, developer);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/statuses")
    public ResponseEntity<StatusName[]> getStatusNames() {
        return ResponseEntity.ok(StatusName.values());
    }

    @GetMapping("/priorities")
    public ResponseEntity<PriorityName[]> getPriorityNames() {
        return ResponseEntity.ok(PriorityName.values());
    }
}