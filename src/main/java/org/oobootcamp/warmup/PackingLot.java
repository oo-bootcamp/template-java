package org.oobootcamp.warmup;

import java.util.ArrayList;
import java.util.List;

public class PackingLot {
    int total;
    int used_number;
    List<Ticket> tickets;

    public PackingLot(int total, int used_number) {
        this.total = total;
        this.used_number = used_number;
        this.tickets = new ArrayList<>();
    }

    public Ticket parking(Car car) {
        if (this.total - this.used_number == 0) {
            throw new RuntimeException("Space is full");
        }

        var ticket = new Ticket(car.getCarNum());
        this.used_number ++;
        this.tickets.add(ticket);
        return ticket;
    }
}
