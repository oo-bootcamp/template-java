package org.oobootcamp.warmup.parkinglot;

import java.util.UUID;

public class Ticket {

    private final UUID id;
    private final String carNum;

    public Ticket(String carNum) {
        this.id = UUID.randomUUID();
        this.carNum = carNum;
    }

    public UUID getId() {
        return id;
    }

    public String getCarNum() {
        return carNum;
    }
}
