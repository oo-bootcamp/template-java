package org.oobootcamp.warmup;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.oobootcamp.warmup.parkinglot.Car;
import org.oobootcamp.warmup.parkinglot.PackingLot;
import org.oobootcamp.warmup.parkinglot.Ticket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraduateParkingBoyTest {

    public GraduateParkingBoy graduateParkingBoy;

    public GraduateParkingBoyTest() {
        this.graduateParkingBoy = new GraduateParkingBoy(
                Lists.newArrayList(new PackingLot(1), new PackingLot(1), new PackingLot(1)));

    }

    @Test
    void should_not_park_when_graduate_parking_boy_parking_given_no_seats() {

        this.graduateParkingBoy.parking(new Car("1111"));
        this.graduateParkingBoy.parking(new Car("2222"));
        this.graduateParkingBoy.parking(new Car("3333"));

        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> {
                    this.graduateParkingBoy.parking(new Car("4444"));

        });
        assertEquals("All space is full", thrown.getMessage());
    }

    @Test
    void should_park_when_graduate_parking_boy_parking_given_the_first_parking_lot_has_space() {
        Car car = new Car("1111");
        Ticket ticket = this.graduateParkingBoy.parking(car);

        assertThat(ticket.getCarNum()).isEqualTo(car.getCarNum());
        assertThat(ticket.getId()).isNotNull();
        assertThat(this.graduateParkingBoy.getParkingLotPosition(car.getCarNum())).isEqualTo(1);
    }

    @Test
    void should_park_when_graduate_parking_boy_parking_given_the_first_parking_lot_is_full_and_the_second_parking_lot_has_space() {
        this.graduateParkingBoy.parking(new Car("1111"));

        Car car = new Car("2222");
        Ticket ticket = this.graduateParkingBoy.parking(car);

        assertThat(ticket.getCarNum()).isEqualTo(car.getCarNum());
        assertThat(ticket.getId()).isNotNull();
        assertThat(this.graduateParkingBoy.getParkingLotPosition(car.getCarNum())).isEqualTo(2);
    }

    @Test
    void should_get_a_car_when_graduate_parking_boy_pick_up_car_given_a_valid_ticket() {
        Car car = new Car("1111");
        Ticket ticket = this.graduateParkingBoy.parking(car);

        Car pickCar = this.graduateParkingBoy.pickup(ticket);

        assertThat(pickCar).isEqualTo(car);
        assertThat(this.graduateParkingBoy.getParkingLotPosition(car.getCarNum())).isEqualTo(1);
    }

    @Test
    void should_not_get_a_car_when_graduate_parking_boy_pick_up_car_given_a_invalid_ticket() {
        Ticket ticket = new Ticket("invalid_car_num");

        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> this.graduateParkingBoy.pickup(ticket));
        assertEquals("Invalid ticket", thrown.getMessage());
    }

    @Test
    void should_not_get_a_car_when_graduate_parking_boy_pick_up_car_given_a_same_ticket_twice() {
        Car car = new Car("1111");
        Ticket ticket = this.graduateParkingBoy.parking(car);

        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            this.graduateParkingBoy.pickup(ticket);
            this.graduateParkingBoy.pickup(ticket);
        });
        assertEquals("This ticket is already used.", thrown.getMessage());
    }
}
