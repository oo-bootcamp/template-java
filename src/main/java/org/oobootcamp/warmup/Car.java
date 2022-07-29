package org.oobootcamp.warmup;

import java.util.UUID;

public class Car {

    private final UUID id;
    private final String carNum;

    public Car(String carNum) {
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
