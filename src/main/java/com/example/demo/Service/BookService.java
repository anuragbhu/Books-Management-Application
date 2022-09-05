package com.example.demo.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BooksDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BooksDB booksDB;

    public String insertBook(Book book) {
        return booksDB.saveBook(book);
    }

    public List<Book> getAllBooks() {
        return booksDB.getBooks();
    }

    public Book getBookById(long id) {
        return booksDB.getBookById(id);
    }

    public String updateBook(Book book) {
        return booksDB.updateBookDetails(book);
    }

    public String deleteBook(long id) {
        return booksDB.deleteBookDetails(id);
    }

    public int getPrice(long id) {
        return booksDB.getPrice(id);
    }

    public int getPrice(long id, String name) {
        return booksDB.getPrice(id, name);
    }
}
