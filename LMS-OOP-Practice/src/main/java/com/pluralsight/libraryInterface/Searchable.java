package com.pluralsight.libraryInterface;

import java.util.List;

public interface Searchable {
     List<LibraryItems> search(String keyboard);
     LibraryItems searchById(int id);
     List<LibraryItems> searchByCategory(String category);
}
