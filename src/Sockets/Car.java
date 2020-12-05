package Sockets;

import java.io.Serializable;

public class Car implements Serializable {
    private final String name;
    private final int year;

    public Car(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Sockets.Car{" + "name='" + name + '\'' + ", year=" + year + '}';
    }
}
