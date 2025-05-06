package book_service.book_service.repository;

import book_service.book_service.dto.BookDto;
import book_service.book_service.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends MongoRepository<BookDto, String> {
    Page<Book> findByUserId(String userId, Pageable pageable);
}