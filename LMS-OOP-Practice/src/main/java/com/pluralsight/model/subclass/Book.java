package com.pluralsight.model.subclass;

import com.pluralsight.libraryInterface.LibraryItems;

public class Book implements LibraryItems {
    private int id;
    private String author;
    private String genre;
    private String numberOfPages;

    public Book(int id, String author, String genre, String numberOfPages) {
       this.id = id;
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
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
