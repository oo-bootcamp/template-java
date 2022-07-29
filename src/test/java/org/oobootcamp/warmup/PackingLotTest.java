package org.oobootcamp.warmup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackingLotTest {

    @Test
    void should_not_pack_when_parking_given_there_has_no_seat() {
        var car = new Car("my_id");

        PackingLot packingLot = new PackingLot(100, 100);

        Exception thrown = Assertions.assertThrows(Exception.class, () -> packingLot.parking(car));
        assertEquals("Space is full", thrown.getMessage());
    }

    @Test
    void should_pack_and_get_a_ticket_when_parking_given_there_has_seats() {
        PackingLot packingLot = new PackingLot(100, 99);
        var car = new Car("my_id");

        Ticket ticket = packingLot.parking(car);

        assertThat(ticket.getCarNum()).isEqualTo(car.getCarNum());
        assertThat(ticket.getId()).isNotNull();
        assertThat(packingLot.used_number).isEqualTo(100);
    }

    @Test
    void should_get_a_car_when_pick_up_car_given_a_valid_ticket() {
        PackingLot packingLot = new PackingLot(100, 99);
        Car car = new Car("my_id");
        Ticket ticket = packingLot.parking(car);

        Car pickCar = packingLot.pickup(ticket);

        assertThat(pickCar).isEqualTo(car);
        assertThat(packingLot.used_number).isEqualTo(99);
    }
}
