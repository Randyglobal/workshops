package com.pluralsight;

public class Book {
    private String title = "";
    private String author = "";
    private String serialNumber = "";
    private boolean availability = true;

    public Book(String title, String author, String serialNumber, boolean availability) {
        this.title = title;
        this.author = author;
        this.serialNumber = serialNumber;
        this.availability = availability;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    public String displayBookInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("-----Book Details-------").append("\n");
        sb.append("Book Title: ").append(this.title).append("\n");
        sb.append("Book Author: ").append(this.author).append("\n");
        sb.append("Serial Number: ").append(this.serialNumber).append("\n");
        sb.append("Availability: ").append(this.availability);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", availability=" + availability +
                '}';
    }
}




/*
* Books should be book
* bookStore should be bookList
* Nomenclature
* Name Library Manager
* */
