package org.oobootcamp.warmup;

import java.util.ArrayList;
import java.util.List;

public class PackingLot {
    int total;
    int used_number;

    private final List<Car> cars;
    private final List<Ticket> tickets;

    public PackingLot(int total, int used_number) {
        this.total = total;
        this.used_number = used_number;
        this.cars = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public Ticket parking(Car car) {
        if (this.total - this.used_number == 0) {
            throw new RuntimeException("Space is full");
        }

        this.cars.add(car);
        var ticket = new Ticket(car.getCarNum());
        this.used_number ++;
        this.tickets.add(ticket);
        return ticket;
    }

    public Car pickup(Ticket ticket) {
        if (this.tickets.contains(ticket)) {
            for (Car car : this.cars) {
                if (car.getCarNum().equals(ticket.getCarNum())) {
                    this.used_number --;
                    return car;
                }
            }
        }
        return null;
    }
}
