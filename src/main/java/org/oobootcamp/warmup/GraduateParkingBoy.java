package org.oobootcamp.warmup;

import org.oobootcamp.warmup.parkinglot.Car;
import org.oobootcamp.warmup.parkinglot.PackingLot;
import org.oobootcamp.warmup.parkinglot.Ticket;

import java.util.HashMap;
import java.util.List;

public class GraduateParkingBoy {
    private final List<PackingLot> parkingLots;

    private final HashMap<String, Integer> belongingToParkingLot;

    public GraduateParkingBoy(List<PackingLot> parkingLots) {
        this.parkingLots = parkingLots;
        this.belongingToParkingLot = new HashMap<>();
    }

    public Ticket parking(Car car) {
        for (int i = 0; i < this.parkingLots.size(); i ++) {
            PackingLot parkingLot = this.parkingLots.get(i);
            if (parkingLot.hasSpace()){
                this.belongingToParkingLot.put(car.getCarNum(), i+1);
                return parkingLot.parking(car);
            }
        }
        throw new RuntimeException("All space is full");
    }

    public int getParkingLotPosition(String carNum){
        return this.belongingToParkingLot.get(carNum);
    }

    public Car pickup(Ticket ticket) {
        if (this.belongingToParkingLot.containsKey(ticket.getCarNum())){
            return this.parkingLots.get(this.getParkingLotPosition(ticket.getCarNum()) - 1).pickup(ticket);
        }
        throw new RuntimeException("Invalid ticket");
    }
}
