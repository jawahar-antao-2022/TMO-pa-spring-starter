package com.galvanize.tmo.paspringstarter.models;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private List<Book> books = new ArrayList<>();
}
