package com.ehayes.portfolio.Ehayes.Portfolio.Model;


public class BarberName {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BarberName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
