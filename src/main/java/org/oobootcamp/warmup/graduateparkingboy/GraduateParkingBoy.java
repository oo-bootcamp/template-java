package org.oobootcamp.warmup.graduateparkingboy;

import org.oobootcamp.warmup.parkinglot.Car;
import org.oobootcamp.warmup.parkinglot.PackingLot;
import org.oobootcamp.warmup.parkinglot.Ticket;

import java.util.List;

public class GraduateParkingBoy {
    private final List<PackingLot> parkingLots;

    public GraduateParkingBoy(List<PackingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        for (PackingLot parkingLot: this.parkingLots) {
            if (parkingLot.hasSpace()){
                return parkingLot.parking(car);
            }
        }
        throw new RuntimeException("All space is full");
    }

    public Car pickup(Ticket ticket) {
        for (PackingLot parkingLot: this.parkingLots) {
            Car car = parkingLot.pickup(ticket);
            if (car != null){
                return car;
            }
        }
        throw new RuntimeException("Invalid ticket");
    }
}
