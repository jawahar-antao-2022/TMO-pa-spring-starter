package com.galvanize.tmo.paspringstarter.services;

import com.galvanize.tmo.paspringstarter.models.Book;

import java.util.List;

public interface BookService {
    Book createBook(Book book);

    List<Book> listBooksByTitle();

    List<Book> deleteBooks();
}
