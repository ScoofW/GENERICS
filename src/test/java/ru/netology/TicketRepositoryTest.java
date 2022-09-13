package ru.netology;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private Ticket first = new Ticket(1, 1000, "AAA", "AAB", 100);
    private Ticket second = new Ticket(2, 2000, "BAC", "BAE", 200);
    private Ticket six = new Ticket(6, 3000, "ABA", "BAA", 300);
    private Ticket five = new Ticket(5, 1500, "YHH", "YHI", 150);
    private Ticket ten = new Ticket(10, 4000, "KJJ", "KJK", 250);
    private Ticket seven = new Ticket(7, 2500, "NMA", "NMB", 350);

    @Test
    void MustSave(){
        repository.save(first);
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void mustShowEmpty() {
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNotEmpty() {
        repository.save(first);
        repository.save(second);
        Ticket[] expected = new Ticket[]{first, second};
        Ticket[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}