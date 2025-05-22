package com.pluralsight.model.subclass;

import com.pluralsight.libraryInterface.LibraryItems;

public class DVD implements LibraryItems {
    private int id;
    private String directions;
    private int runtime;
    private int number;

    public DVD(int id, String directions, int runtime, int number) {
       this.id = id;
        this.directions = directions;
        this.runtime = runtime;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void checkOut() {

    }

    @Override
    public void returnItem() {

    }

    @Override
    public String getItemDetails() {

        return null;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0;
    }
}
