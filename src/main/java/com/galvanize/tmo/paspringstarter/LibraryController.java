package com.galvanize.tmo.paspringstarter;

import com.galvanize.tmo.paspringstarter.models.Book;
import com.galvanize.tmo.paspringstarter.models.Library;
import com.galvanize.tmo.paspringstarter.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
public class LibraryController {

    Logger logger = LoggerFactory.getLogger("com.galvanize.tmo.paspringstarter.LibraryController");

    @Autowired
    BookService bookService;

    @GetMapping("/health")
    public void health() {
    }

    @PostMapping("/api/books")
    public ResponseEntity createBook(@RequestBody Book request)  {
        Book book = bookService.createBook(request);
        logger.info("book: " + request.toString());
        return new ResponseEntity(book, HttpStatus.CREATED);
    }

    @GetMapping("/api/books")
    public ResponseEntity listBooks() {
        Library library = new Library();
        library.setBooks(bookService.listBooksByTitle());
        return new ResponseEntity(library, HttpStatus.OK);
    }

    @DeleteMapping("/api/books")
    public ResponseEntity deleteBooks(){
        bookService.deleteBooks();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
