package com.pluralsight.model;

import com.pluralsight.libraryInterface.LibraryItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryMember extends Person{
    private String memberId;
    private List<LibraryItems> borrowedItems;
    private boolean status;

    public LibraryMember(String name, int id, String contactInfo, String memberId, boolean status) {
        super(name, id, contactInfo);
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
        this.status = status;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<LibraryItems> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<LibraryItems> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void addBorrowedItems(LibraryItems item){
        if (item != null){
            this.borrowedItems.add(item);
        }
    }

    public void removeItem(LibraryItems item){
        if (item != null){
            this.borrowedItems.remove(item);
        }
    }

    public void displayCurrentItems() {
        if (borrowedItems.isEmpty()){
            System.out.println("No Available items");
        }
        for (LibraryItems item : borrowedItems){
            String result = item.getItemDetails();
            System.out.println("Items" + result);
        }
    }

    public void totalLateFee(){
        double totalFee = 0;
//Relate to transaction class
    }
}
