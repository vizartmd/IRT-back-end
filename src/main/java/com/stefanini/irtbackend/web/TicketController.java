package com.stefanini.irtbackend.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stefanini.irtbackend.domain.dto.TicketDto;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;
import com.stefanini.irtbackend.service.TicketService;
import com.stefanini.irtbackend.service.UserService;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/creators")
//    String getAllTicketsCreators() throws JsonProcessingException {
//        System.out.println("In getAllTicketsCreators controller!");
//        System.out.println("ticketService.getAllTicketsCreators().toString(): " + ticketService.getAllTicketsCreators().toString());
//        return ticketService.getAllTicketsCreators();
//    }
//
//    @GetMapping("/developers")
//    String getAllTicketsDevelopers() throws JsonProcessingException {
//        System.out.println("In getAllTicketsDevelopers controller!");
//        System.out.println("ticketService.getAllTicketsDevelopers().toString(): " + ticketService.getAllTicketsDevelopers().toString());
//        return ticketService.getAllTicketsDevelopers();
//    }

    @GetMapping("/{id}")
    ResponseEntity<Ticket> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @GetMapping("/kanban")
    String findAllTickets() throws JsonProcessingException {
        return ticketService.getListTicketDTO();
    }

//    @PostMapping("/{creator_id}/{developer_id}")
//    ResponseEntity<Ticket> create(@RequestBody Ticket ticket, @PathVariable(value = "creator_id") Long creator_id, @PathVariable(value = "developer_id") Long developer_id ) {
//        User creator_user = userService.findById(creator_id);
//        User developer_user = userService.findById(developer_id);
//        ticket.setCreator(creator_user);
//        ticket.setDeveloper(developer_user);//dto or service
//        Ticket createdTicket = ticketService.create(ticket);
//        return ResponseEntity.created(URI.create("/tickets/" + createdTicket.getId())).body(createdTicket);
//    }

    @PostMapping
    ResponseEntity<Ticket> create(@RequestBody TicketDto ticketDto) throws ParseException {
        Ticket createdTicket = ticketService.createTicketFromDTO(ticketDto);
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