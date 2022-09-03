package com.galvanize.tmo.paspringstarter.services;

import com.galvanize.tmo.paspringstarter.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    private List<Book> books = new ArrayList<Book>();

    @Override
    public Book createBook(Book book) {
        int id = books.size() + 1;
        book.setId(id);
        books.add(book);
        return book;
    }

    @Override
    public List<Book> listBooksByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

    @Override
    public List<Book> deleteBooks() {
        books.clear();
        return books;
    }
}
