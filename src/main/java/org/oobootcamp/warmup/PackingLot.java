package org.oobootcamp.warmup;

import java.util.ArrayList;
import java.util.List;

public class PackingLot {
    private final int total;

    private final List<Car> cars;
    private final List<Ticket> tickets;

    public PackingLot(int total) {
        this.total = total;
        this.cars = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public Ticket parking(Car car) {
        if (this.total - this.getUsedNumber() == 0) {
            throw new RuntimeException("Space is full");
        }

        this.cars.add(car);
        var ticket = new Ticket(car.getCarNum());
        this.tickets.add(ticket);
        return ticket;
    }

    public Car pickup(Ticket ticket) {
        if (this.tickets.contains(ticket)) {
            for (int i = 0; i < this.cars.size(); i ++) {
                Car car = this.cars.get(i);
                if (car.getCarNum().equals(ticket.getCarNum())) {
                    return this.cars.remove(i);
                }
            }
            throw new RuntimeException("This ticket is already used.");
        }
        throw new RuntimeException("Invalid ticket");
    }

    public int getUsedNumber() {
        return cars.size();
    }
}
