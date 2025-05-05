package book_service.book_service.repository;

import book_service.book_service.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

//import java.awt.print.Pageable;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByAssignedUserId(String userId);
    Page<Book> findByUserId(String userId, Pageable pageable);
}