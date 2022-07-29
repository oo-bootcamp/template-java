package org.oobootcamp.warmup;

import java.util.ArrayList;
import java.util.List;

public class PackingLot {
    int total;
    int used_number;
    List<Car> cars;

    public PackingLot(int total, int used_number) {
        this.total = total;
        this.used_number = used_number;
        this.cars = new ArrayList<>();
    }

    public Car parking(String car_number) {
        if (this.total - this.used_number == 0) {
            throw new RuntimeException("Space is full");
        }

        var car = new Car(car_number);
        this.cars.add(car);
        this.used_number++;
        return car;
    }
}
