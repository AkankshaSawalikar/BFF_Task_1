
package book_service.book_service.controller;

import book_service.book_service.model.Book;
import book_service.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Endpoint for creating a new book
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    // Endpoint to fetch top N books for a user
    @GetMapping("/by-user-limit")
    public List<Book> getTopBooksByUser(
            @RequestParam String userId,
            @RequestParam(defaultValue = "100") int limit) {
        return bookService.getTopBooksByUser(userId, limit);
    }

    // Endpoint to fetch paginated books for a user
//    @GetMapping("/by-user")
//    public Page<Book> getBooksByUser(
//            @RequestParam String userId,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size) {
//        return bookService.getBooksByUser(userId, page, size);
//    }
    @GetMapping("/by-user")
    public List<Book> getBooksByUser(
            @RequestParam String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return bookService.getBooksByUser(userId, page, size).getContent(); // Convert Page to List
    }


    // Endpoint for fetching all paginated books
    @GetMapping
    public List<Book> getPaginatedBooks(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "5") int size) {
        return bookService.getPaginatedBooks(page, size);
    }

}


