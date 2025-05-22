package com.pluralsight.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Transaction {
    private int transactionId;
    private int memberId;
    private int itemId;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public Transaction(int transactionId, int memberId, int itemId, LocalDate checkoutDate, LocalDate dueDate) {
        this.transactionId = transactionId;
        this.memberId = memberId;
        this.itemId = itemId;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getItemId() {
        return itemId;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isOverdure(LocalDate currentDate){
       if (returnDate == null){
           return currentDate.isAfter(dueDate);
       }else{
           return returnDate.isAfter(dueDate);
       }
    }

    public int getDaysOverdue(LocalDate currentDate){
        LocalDate comparisonDate = (returnDate != null) ? returnDate : currentDate;
        if (comparisonDate.isAfter(dueDate)){
//            We use chronoUnit, this gives the difference between dates
            return (int) ChronoUnit.DAYS.between(dueDate, comparisonDate);
        }
        return 0;
    }

    public double calculateLateFeeRate(double dailyRateFee, LocalDate currentDate){
        int dateOverdue = getDaysOverdue(currentDate);
        if (dateOverdue > 0){
            return dateOverdue * dailyRateFee;
        }
        return  0.0;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", memberId=" + memberId +
                ", itemId=" + itemId +
                ", checkoutDate=" + checkoutDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + (returnDate != null ? returnDate : LocalDateTime.parse("N/A"))  +
                '}';
    }
}

