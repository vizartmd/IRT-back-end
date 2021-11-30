package com.stefanini.irtbackend.units;

import com.stefanini.irtbackend.dao.TicketDao;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.NotFoundException;
import com.stefanini.irtbackend.domain.entity.Ticket;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;
import com.stefanini.irtbackend.service.impl.TicketServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {


    @Mock
    private TicketDao ticketDao;

    @Mock
    private UserDao userDao;


    private TicketServiceImpl ticketServiceImplTest;

    static Ticket ticket1;
    static Ticket ticket2;

    @BeforeEach
    void setUp() {
        ticketServiceImplTest = new TicketServiceImpl(ticketDao, userDao);

        ticket1 = new Ticket();
        ticket1.setId(1L);
        ticket1.setStatus(StatusName.CLOSED);
        ticket1.setDescription("description");
        ticket1.setPriority(PriorityName.HIGH);
    }


    @Test
    void findAll_RunsOK() {
        List<Ticket> returnTickets = new ArrayList<>();
        returnTickets.add(ticket1);

        Mockito.when(ticketDao.findAll()).thenReturn(returnTickets);

        List<Ticket> foundTickets = ticketServiceImplTest.findAll();

        Assertions.assertNotNull(foundTickets);
        Assertions.assertEquals(1, foundTickets.size());
    }


    @Test
    void getTicketById_RunsOK() {
        Mockito.when(ticketDao.findById(ticket1.getId())).thenReturn(Optional.of(ticket1));
        Ticket foundTicket = ticketServiceImplTest.findById(ticket1.getId());
        Assertions.assertEquals(foundTicket.getTitle(), ticket1.getTitle());

    }

    @Test
    void canNotFoundTicketById() {
        Mockito.when(ticketDao.findById(2L)).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> ticketServiceImplTest.findById(2L));
    }

}
