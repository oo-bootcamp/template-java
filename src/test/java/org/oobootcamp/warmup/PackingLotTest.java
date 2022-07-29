package org.oobootcamp.warmup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackingLotTest {

    @Test
    void should_not_pack_when_parking_given_there_has_no_seat() {
        PackingLot packing_lot = new PackingLot(100, 100);
        Exception thrown = Assertions.assertThrows(Exception.class, () ->
            packing_lot.parking("my_id")
        );
        assertEquals("Space is full", thrown.getMessage());
    }

    @Test
    void should_pack_and_get_a_ticket_when_parking_given_there_has_seats() {
        PackingLot packing_lot = new PackingLot(100, 99);

        String carNumber = "my_id";
        Car car = packing_lot.parking(carNumber);
        assertThat(car.getCarNum()).isEqualTo(carNumber);
        assertThat(car.getId()).isNotNull();
        assertThat(packing_lot.used_number).isEqualTo(100);
    }
}
