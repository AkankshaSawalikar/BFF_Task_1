package book_service.book_service.controller;

import book_service.book_service.dto.BookDto;
import book_service.book_service.model.Book;
import book_service.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDto book) {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/by-user")
    public Page<Book> getBooksByUser(
            @RequestParam String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return bookService.getBooksByUser(userId, page, size);
    }

    @GetMapping
    public List<Book> getPaginatedBooks(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size) {
        return bookService.getPaginatedBooks(page, size);
    }
}
