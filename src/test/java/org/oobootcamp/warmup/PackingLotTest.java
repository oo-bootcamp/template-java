package org.oobootcamp.warmup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackingLotTest {

    @Test
    void should_not_pack_when_parking_given_there_has_no_seat() {
        var car = new Car("my_id");
        PackingLot packing_lot = new PackingLot(100, 100);

        Exception thrown = Assertions.assertThrows(Exception.class, () -> packing_lot.parking(car));
        assertEquals("Space is full", thrown.getMessage());
    }

    @Test
    void should_pack_and_get_a_ticket_when_parking_given_there_has_seats() {
        PackingLot packing_lot = new PackingLot(100, 99);

        var car = new Car("my_id");
        Ticket ticket = packing_lot.parking(car);
        assertThat(ticket.getCarNum()).isEqualTo(car.getCarNum());
        assertThat(ticket.getId()).isNotNull();
        assertThat(packing_lot.used_number).isEqualTo(100);
    }
}
