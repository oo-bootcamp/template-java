package org.oobootcamp.warmup.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class PackingLot {
    private final int capacity;

    private final Map<Ticket, Car> ticketCarMap;

    public PackingLot(int capacity) {
        this.capacity = capacity;
        this.ticketCarMap = new HashMap<>();
    }

    public Ticket parking(Car car) {
        if (! hasSpace()) {
            throw new RuntimeException("Space is full");
        }

        Ticket ticket = new Ticket();
        this.ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car pickup(Ticket ticket) {

        if (this.ticketCarMap.containsKey(ticket)) {
            return this.ticketCarMap.remove(ticket);
        }
        throw new RuntimeException("Invalid ticket");
    }


    public boolean hasSpace() {
        return this.capacity - this.ticketCarMap.size() != 0;
    }

    public int restSpaceCount() {
        return this.capacity - this.ticketCarMap.size();
    }
}
