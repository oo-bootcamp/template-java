package org.oobootcamp.warmup.smartparkingboy;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.oobootcamp.warmup.parkinglot.Car;
import org.oobootcamp.warmup.parkinglot.PackingLot;
import org.oobootcamp.warmup.parkinglot.Ticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {

    public SmartParkingBoy smartParkingBoy;
    public PackingLot packingLotA;
    public PackingLot packingLotB;

    public SmartParkingBoyTest() {
        this.packingLotA = new PackingLot(2);
        this.packingLotB = new PackingLot(2);
        this.smartParkingBoy = new SmartParkingBoy(
                Lists.newArrayList(packingLotA, packingLotB));
    }

    @Test
    void should_park_to_parking_lot_B_when_parking_given_parking_lot_B_has_most_available_space() {
        this.packingLotA.parking(new Car());

        Car car = new Car();
        Ticket ticket = this.smartParkingBoy.parking(car);

        assertNotNull(ticket);
        assertEquals(car, this.packingLotB.pickup(ticket));
    }

    @Test
    void should_park_to_parking_lot_A_when_parking_given_both_parking_lot_A_and_B_have_most_available_space() {
        this.packingLotA.parking(new Car());
        this.packingLotB.parking(new Car());

        Car car = new Car();
        Ticket ticket = this.smartParkingBoy.parking(car);

        assertNotNull(ticket);
        assertEquals(car, this.packingLotA.pickup(ticket));
    }

    @Test
    void should_raise_parking_lots_are_full_error_message_when_parking_given_boy_given_all_parking_lot_are_full() {
        this.packingLotA.parking(new Car());
        this.packingLotA.parking(new Car());
        this.packingLotB.parking(new Car());
        this.packingLotB.parking(new Car());

        Exception thrown = Assertions.assertThrows(RuntimeException.class, () ->
                this.smartParkingBoy.parking(new Car()));
        assertEquals("Space is full", thrown.getMessage());
    }

    @Test
    void should_pick_up_car_when_pick_up_given_valid_ticket_of_parking_lot_A() {
        Car myCar = new Car();
        Ticket ticket = this.packingLotA.parking(myCar);

        Car car = this.smartParkingBoy.pickup(ticket);

        assertEquals(car, myCar);
    }

    @Test
    void should_raise_invalid_ticket_error_message_when_pick_up_given_invalid_ticket() {
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> this.smartParkingBoy.pickup(new Ticket()));
        assertEquals("Invalid ticket", thrown.getMessage());
    }

    @Test
    void should_raise_invalid_ticket_error_message_when_pick_up_given_a_valid_ticket_was_used_twice() {
        Ticket ticket = this.packingLotA.parking(new Car());
        this.smartParkingBoy.pickup(ticket);

        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> this.smartParkingBoy.pickup(ticket));
        assertEquals("Invalid ticket", thrown.getMessage());
    }
}
