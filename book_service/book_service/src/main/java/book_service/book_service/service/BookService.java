
package book_service.book_service.service;
import book_service.book_service.model.Book;
import book_service.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    public List<Book> getTopBooksByUser(String userId, int limit) {
        return bookRepository.findByUserId(userId, PageRequest.of(0, limit)).getContent();
    }

    // Fetch paginated books for a user
    public Page<Book> getBooksByUser(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findByUserId(userId, pageable);
    }

    public List<Book> getPaginatedBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());
        return bookRepository.findAll(pageable).getContent();
    }
}
