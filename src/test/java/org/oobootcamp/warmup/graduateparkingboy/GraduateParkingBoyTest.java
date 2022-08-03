package org.oobootcamp.warmup.graduateparkingboy;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.oobootcamp.warmup.parkinglot.Car;
import org.oobootcamp.warmup.parkinglot.PackingLot;
import org.oobootcamp.warmup.parkinglot.Ticket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GraduateParkingBoyTest {

    public GraduateParkingBoy graduateParkingBoy;
    public PackingLot packingLotA;
    public PackingLot packingLotB;

    public GraduateParkingBoyTest() {
        this.packingLotA = new PackingLot(1);
        this.packingLotB = new PackingLot(1);
        this.graduateParkingBoy = new GraduateParkingBoy(
                Lists.newArrayList(packingLotA, packingLotB));

    }

    @Test
    void should_not_park_when_graduate_parking_boy_parking_given_no_seats() {

        this.graduateParkingBoy.parking(new Car());
        this.graduateParkingBoy.parking(new Car());

        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> this.graduateParkingBoy.parking(new Car()));
        assertEquals("All space is full", thrown.getMessage());
    }

    @Test
    void should_park_when_graduate_parking_boy_parking_given_the_first_parking_lot_has_space() {
        Car car = new Car();
        Ticket ticket = this.graduateParkingBoy.parking(car);

        assertNotNull(ticket);

        assertThat(this.packingLotA.pickup(ticket)).isEqualTo(car);
    }

    @Test
    void should_park_when_graduate_parking_boy_parking_given_the_first_parking_lot_is_full_and_the_second_parking_lot_has_space() {
        this.graduateParkingBoy.parking(new Car());

        Car car = new Car();
        Ticket ticket = this.graduateParkingBoy.parking(car);

        assertNotNull(ticket);
        assertThat(this.packingLotB.pickup(ticket)).isEqualTo(car);
    }

    @Test
    void should_get_a_car_when_graduate_parking_boy_pick_up_car_given_a_valid_ticket() {
        Car car = new Car();
        Ticket ticket = this.graduateParkingBoy.parking(car);

        Car pickCar = this.graduateParkingBoy.pickup(ticket);

        assertThat(pickCar).isEqualTo(car);
    }

    @Test
    void should_not_get_a_car_when_graduate_parking_boy_pick_up_car_given_a_invalid_ticket() {
        Ticket ticket = new Ticket();

        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> this.graduateParkingBoy.pickup(ticket));
        assertEquals("Invalid ticket", thrown.getMessage());
    }
}