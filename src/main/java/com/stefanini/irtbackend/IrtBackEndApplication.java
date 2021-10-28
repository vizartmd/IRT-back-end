package com.stefanini.irtbackend;

import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "com.stefanini.irtbackend")
@EnableJpaAuditing
public class IrtBackEndApplication {
//    @Autowired
//    TicketService ticketService;
//
//    public IrtBackEndApplication(TicketService ticketService) {
//        this.ticketService = ticketService;
//    }
//
//    Ticket ticket = new Ticket();
//    ticket.set
//
//    void addTicketToUser(){
//        ticketService.create(ticket);
//    }

    public static void main(String[] args) {
        SpringApplication.run(IrtBackEndApplication.class, args);


    }




}
