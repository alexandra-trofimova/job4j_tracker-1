package ru.job4j.poly;

public class Bus implements Transport {
    private int pass = 0;

    @Override
    public void ride() {
        this.ride();
    }

    @Override
    public void passengers(int number) {
        pass = pass + number;
    }

    @Override
    public double refuel(double fuel) {
        return (fuel * 50);
    }
}
