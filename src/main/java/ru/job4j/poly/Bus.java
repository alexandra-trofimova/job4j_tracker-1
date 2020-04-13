package ru.job4j.poly;

public class Bus implements Transport {
    private int pass = 0;

    @Override
    public void ride() {
        System.out.println("The bus is going on a tour now.");
    }

    @Override
    public void passengers(int number) {
        pass = pass + number;
        System.out.println("There are " + pass + " passengers in the bus.");
    }

    @Override
    public double refuel(double fuel) {
        return (fuel * 50);
    }
}
