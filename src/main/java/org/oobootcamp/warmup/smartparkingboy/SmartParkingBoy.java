package org.oobootcamp.warmup.smartparkingboy;

import org.oobootcamp.warmup.parkinglot.Car;
import org.oobootcamp.warmup.parkinglot.PackingLot;
import org.oobootcamp.warmup.parkinglot.Ticket;
import org.oobootcamp.warmup.parkinglot.exception.ParkingLotInvalidTicket;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy {
    private final List<PackingLot> parkingLots;

    public SmartParkingBoy(ArrayList<PackingLot> packingLots) {
        this.parkingLots = packingLots;
    }

    public Ticket parking(Car car) {
        int maxRestSpaceCount = 0;
        int parkingLotPosition = 0;
        for (PackingLot parkingLot: this.parkingLots) {
            if (parkingLot.restSpaceCount() > maxRestSpaceCount) {
                maxRestSpaceCount = parkingLot.restSpaceCount();
                parkingLotPosition = this.parkingLots.indexOf(parkingLot);
            }
        }
        PackingLot packingLot = this.parkingLots.get(parkingLotPosition);
        return packingLot.parking(car);
    }

    public Car pickup(Ticket ticket) {
        for (PackingLot parkingLot: this.parkingLots) {
            Car car = parkingLot.pickup(ticket);
            if (car != null){
                return car;
            }
        }
        throw new ParkingLotInvalidTicket();
    }
}
