package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.BookRepository;
import com.example.springBoot2.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;                         //instead of this controller we can use @Autowired annotation but since using final so we need to use constructor
    }
    private final List<Book> books = List.of(
            new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 234),
            new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281),
            new Book("1984", "George Orwell", 1949, 328)
    );


    @GetMapping("")
    public List<Book> getAllItems() {
        return bookRepository.findAll();
    }

    @PostMapping("/add")
    public Book addItem(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @GetMapping("/{id}")
    public Book getItem(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Book updateItem(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        bookRepository.deleteById(id);
    }
}
