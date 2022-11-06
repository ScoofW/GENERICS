package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;
import ru.netology.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {

    private TicketManager manager ;
    private Ticket first = new Ticket(1, 1000, "AAA", "AAB", 100);
    private Ticket second = new Ticket(2, 2000, "BAC", "BAE", 200);
    private Ticket six = new Ticket(6, 3000, "ABA", "BAA", 300);
    private Ticket five = new Ticket(5, 1500, "YHH", "YHI", 150);
    private Ticket ten = new Ticket(10, 4000, "KJJ", "KJK", 250);
    private Ticket seven = new Ticket(7, 2500, "NMA", "NMB", 350);

    @BeforeEach
    public void setUp() {
        manager = new TicketManager(new TicketRepository());
        manager.add(first);
        manager.add(second);
        manager.add(six);
        manager.add(five);
        manager.add(ten);
        manager.add(seven);
    }

    @Test
    void mustShowOffers() {
        Ticket[] expected = new Ticket[]{first, five, second, seven, six, ten};
        assertArrayEquals(expected, manager.showOffers());
    }

    @Test
    void mustSearchIfExists() {
        Ticket[] expected = new Ticket[]{second};
        assertArrayEquals(expected, manager.findAll("BAC", "BAE"));
    }

    @Test
    void mustSearchIfNotExists() {
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, manager.findAll("AAA", "AAJ"));
    }
}