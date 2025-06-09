package com.pluralsight.libraryManager;

import com.pluralsight.libraryInterface.LibraryItems;
import com.pluralsight.libraryInterface.Searchable;
import com.pluralsight.model.LibraryMember;
import com.pluralsight.model.Transaction;
import com.pluralsight.model.subclass.Book;
import com.pluralsight.model.subclass.DVD;
import com.pluralsight.model.subclass.Magazine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library implements Searchable {
//    using the map for quick id and member search
    private Map<Integer, LibraryItems> itemsMap;
    private Map<Integer, LibraryMember> memberMap;
    private List<Transaction> transactions = new ArrayList<>();
    private int nextGeneratedId = 1;
    private int getNextGeneratedId(){
        return  nextGeneratedId++;
    }

    public Library(Map<Integer, LibraryItems> itemsMap, Map<Integer, LibraryMember> memberMap) {
        this.itemsMap =  new HashMap<>();
        this.memberMap = new HashMap<>();
    }

    public void addItems(LibraryItems items){
        if (itemsMap.containsKey(items.getId())){
            System.out.println("System Error: " + items.getId() + "Already exist");
        }else{
            itemsMap.put(items.getId(), items);
            System.out.println("Item Added to Library: " + items.getTitle());
        }
    }
    public void addItems(LibraryMember member){
      if (memberMap.containsKey(member.getId())){
          System.out.println("System Error: " + member.getId() + "Already exist");
      }else {
          memberMap.put(member.getId(), member);
          System.out.println("Member Added to Library: " + member.getName());
      }
    }
    public void removeItem(int itemId){
     if (itemsMap.containsKey(itemId)){
//         if item borrowed, we cannot remove the member
         if (!itemsMap.get(itemId).isAvailable()){
             System.out.println("Cannot remove item with ID: " + itemId + " Which is borrowed.");
         }else{
             itemsMap.remove(itemId);
             System.out.println("Item with ID: " + itemId + " Has been removed");
         }
     }else {
         System.out.println("System Error");
     }
    }
    public void removeMember(int memberId){
      if (memberMap.containsKey(memberId)){
//          if member borrowed, cannot remove
          if (!memberMap.get(memberId).getBorrowedItems().isEmpty()){
              System.out.println("Cannot remove member with Id: " + memberId + " has borrowed Item");
          }else{
              memberMap.remove(memberId);
              System.out.println("Member with Id: " + memberId + " Has been removed");
          }
      }
    }
    @Override
    public List<LibraryItems> search(String title) {
        List<LibraryItems> result = new ArrayList<>();
        for (LibraryItems item : itemsMap.values()){
             if (item.getTitle().toLowerCase().contains(title.toLowerCase())){
                 result.add(item);
             }
        }
        return result;
    }

    @Override
    public LibraryItems searchById(int id) {
        return itemsMap.get(id);
    }

    @Override
    public List<LibraryItems> searchByCategory(String category) {
        List<LibraryItems> result = new ArrayList<>();
        for (LibraryItems item : itemsMap.values()){
            if (item instanceof Book){
                Book book = (Book) item;
                if (book.getAuthor().toLowerCase().contains(category.toLowerCase())){
                    result.add(book);
                }
            }
            if (item instanceof DVD){
                DVD dvd = (DVD) item;
                String dvdCategory = String.valueOf(dvd.getNumber());
                if (dvdCategory.toLowerCase().contains(category.toLowerCase())){
                    result.add(dvd);
                }
            }
            if (item instanceof Magazine){
                Magazine magazine = (Magazine) item;
                String magazineCategory = String.valueOf(magazine.getMonth());
                if (magazineCategory.toLowerCase().contains(category.toLowerCase())){
                    result.add(magazine);
                }
            }
        }
        return result;
    }
    public String borrowedItems(int itemId, int memberId){
        LibraryMember member = memberMap.get(memberId);
        LibraryItems items = itemsMap.get(itemId);

        if (member == null){
            return "System Error: Member does not exist";
        }
        if (items == null){
            return "System Error: Item does not exist";
        }
        if (!items.isAvailable()){
            return "System Error: The Item with Title" + items.getTitle() + " with id " + items.getId() + " is not available";

        }
        items.checkOut();
        member.addBorrowedItems(items);

//        Transaction record
        LocalDate checkoutDate = LocalDate.now();
        LocalDate dueDate = checkoutDate.plusDays(14);
        Transaction transaction = new Transaction(getNextGeneratedId(), memberId, itemId, checkoutDate, dueDate);
         transactions.add(transaction);
         return  "Transaction Successfully Updated";
    }

    public String returnedItem(int memberId, int itemId){
        LibraryItems item = itemsMap.get(itemId);
        LibraryMember member = memberMap.get(memberId);

        if (member == null){
            return "System Error: Member does not exist";
        }
        if (item == null){
            return "System Error: Item does not exist";
        }

        boolean memberHasItem = member.getBorrowedItems().contains(item);
        if (!memberHasItem){
            return "System Error: Member with name" + member.getName() + " Did not borrow";
        }
        item.returnItem();
        member.removeItem(item);
        return "returned Item";
    }


}
