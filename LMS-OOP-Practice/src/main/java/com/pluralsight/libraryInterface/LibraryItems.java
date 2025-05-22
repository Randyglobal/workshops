package com.pluralsight.libraryInterface;

public interface LibraryItems {
     boolean isAvailable();
     void checkOut();
     void returnItem();
     String getItemDetails();
     int getId();
     String getTitle();
     double calculateLateFee(int daysLate);
}
