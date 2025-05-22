package com.pluralsight.model.subclass;

import com.pluralsight.libraryInterface.LibraryItems;

import java.time.LocalDateTime;

public class Magazine implements LibraryItems {
    private int id;
    private int issueNumber;
    private LocalDateTime month;
    private LocalDateTime year;

    public Magazine(int id, int issueNumber, LocalDateTime month, LocalDateTime year) {
        this.id = id;
        this.issueNumber = issueNumber;
        this.month = month;
        this.year = year;
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

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public LocalDateTime getMonth() {
        return month;
    }

    public void setMonth(LocalDateTime month) {
        this.month = month;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
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
