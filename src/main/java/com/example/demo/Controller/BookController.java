package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @ApiOperation("This end point is for inserting the book")
    @PostMapping("/insertBook")
    public String insertBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/updateBook")
    public String updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }

    // localhost:8081/getPrice?id=1001
    @GetMapping("/getPrice")
    public int getPrice(@RequestParam long id) {
        return bookService.getPrice(id);
    }

    // Both are corrects:
    // localhost:8081/getPriceV2?id=1001&name=Anurag+Pandey
    // localhost:8081/getPriceV2?id=1001&name=Anurag Pandey
    @GetMapping("/getPriceV2")
    public int getPriceV2(@RequestParam long id, String name) {
        System.out.println("ID: " + id + " AuthorName: " + name);
        return bookService.getPrice(id, name);
    }
}
