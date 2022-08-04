package org.oobootcamp.warmup.graduateparkingboy;

import org.oobootcamp.warmup.ParkingBoy;
import org.oobootcamp.warmup.graduateparkingboy.exception.GraduateParkingBoyAllSpaceIsFull;
import org.oobootcamp.warmup.parkinglot.Car;
import org.oobootcamp.warmup.parkinglot.PackingLot;
import org.oobootcamp.warmup.parkinglot.Ticket;

import java.util.ArrayList;
import java.util.List;

public class GraduateParkingBoy extends ParkingBoy {
    public GraduateParkingBoy(List<PackingLot> parkingLots) {
        super((ArrayList<PackingLot>) parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        for (PackingLot parkingLot: this.getParkingLots()) {
            if (parkingLot.hasSpace()){
                return parkingLot.parking(car);
            }
        }
        throw new GraduateParkingBoyAllSpaceIsFull();
    }
}
