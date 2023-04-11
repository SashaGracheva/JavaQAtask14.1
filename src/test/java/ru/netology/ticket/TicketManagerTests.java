package ru.netology.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void shouldFindAllTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, 3802, "LED", "DME", 90);
        Ticket ticket2 = new Ticket(2, 4627, "LED", "DME", 60);
        Ticket ticket3 = new Ticket(3, 7429, "LED", "DME", 90);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("LED", "DME");
        Ticket[] expected = {ticket1, ticket2, ticket3};


        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(1, 3802, "LED", "DME", 90);
        Ticket ticket2 = new Ticket(2, 4627, "LED", "DME", 60);
        Ticket ticket3 = new Ticket(3, 5499, "LED", "KGD", 120);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] actual = manager.findAll("LED", "KGD");
        Ticket[] expected = {ticket3};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTicketsFromCheap() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket4 = new Ticket(1, 3802, "LED", "DME", 90);
        Ticket ticket5 = new Ticket(2, 4627, "LED", "DME", 60);
        Ticket ticket3 = new Ticket(3, 7429, "LED", "DME", 90);
        Ticket ticket2 = new Ticket(4, 5499, "LED", "KGD", 120);
        Ticket ticket1 = new Ticket(5, 2799, "KGD", "LED", 120);



        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] actual = manager.findAll("LED", "DME");
        Ticket[] expected = {ticket4, ticket5, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket4 = new Ticket(1, 3802, "LED", "DME", 90);
        Ticket ticket5 = new Ticket(2, 4627, "LED", "DME", 60);
        Ticket ticket3 = new Ticket(3, 7429, "LED", "DME", 90);
        Ticket ticket2 = new Ticket(4, 5499, "LED", "KGD", 120);
        Ticket ticket1 = new Ticket(5, 2799, "KGD", "LED", 120);



        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] actual = manager.findAll("LED", "LED");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
