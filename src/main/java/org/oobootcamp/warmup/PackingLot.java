package org.oobootcamp.warmup;

import java.util.ArrayList;
import java.util.List;

public class PackingLot {
    private final int total;
    private int usedNumber = 0;

    private final List<Car> cars;
    private final List<Ticket> tickets;

    public PackingLot(int total) {
        this.total = total;
        this.cars = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public Ticket parking(Car car) {
        if (this.total - this.usedNumber == 0) {
            throw new RuntimeException("Space is full");
        }

        this.cars.add(car);
        var ticket = new Ticket(car.getCarNum());
        this.usedNumber++;
        this.tickets.add(ticket);
        return ticket;
    }

    public Car pickup(Ticket ticket) {
        if (this.tickets.contains(ticket)) {
            for (Car car : this.cars) {
                if (car.getCarNum().equals(ticket.getCarNum())) {
                    this.usedNumber--;
                    return car;
                }
            }
        }
        return null;
    }

    public int getUsedNumber() {
        return usedNumber;
    }
}
