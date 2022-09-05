package com.example.demo.Repository;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksDB {
    ArrayList<Book> booksList = new ArrayList<>();

    public String saveBook(Book book) {
        for(Book books : booksList) {
            if(books.getId() == book.getId())
                return "Not able to store the book!";
        }
        booksList.add(book);
        System.out.println(book + " is inserted.");
        return "Able to store the book";
    }

    public List<Book> getBooks() {
        return booksList;
    }

    public Book getBookById(long id) {
        for(Book book : booksList) {
            if(book.getId() == id)
                return book;
        }
        return null;
    }

    public String updateBookDetails(Book book) {
        for(Book books : booksList) {
            if(books.getId() == book.getId()) {
                booksList.remove(books);
                booksList.add(book);
                return "Book details updated successfully";
            }
        }
        return "Book Id does not exist";
    }

    public String deleteBookDetails(long id) {
        for(Book books : booksList) {
            if(books.getId() == id) {
                booksList.remove(books);
                return "Book deleted successfully";
            }
        }
        return "Book Id does not exist";
    }

    public int getPrice(long id) {
        for(Book books : booksList) {
            if(books.getId() == id) {
                return books.getCost();
            }
        }
        return -1;
    }

    public int getPrice(long id, String name) {
        for(Book books : booksList) {
            if(books.getId() == id && books.getAuthorName().equals(name)) {
                return books.getCost();
            }
        }
        return -1;
    }
}
