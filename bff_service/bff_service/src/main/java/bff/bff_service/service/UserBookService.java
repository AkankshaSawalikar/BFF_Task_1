package bff.bff_service.service;

import bff.bff_service.dto.BookDto;
import bff.bff_service.dto.ResponseDto;
import bff.bff_service.dto.UserDto;
import bff.bff_service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class UserBookService {

    @Autowired
    private RestTemplate restTemplate;

    private final String USER_SERVICE_BASE_URL = "http://localhost:8081";
    private final String BOOK_SERVICE_BASE_URL = "http://localhost:8082";

    public ResponseDto getUserBooks(String userId, Integer page, Integer size) {
        Integer pageNum = (page != null) ? page : 0;
        Integer pageSize = (size != null) ? size : 5;


        UserDto user = restTemplate.getForObject(USER_SERVICE_BASE_URL + "/users/" + userId, UserDto.class);
        if (user == null) {
            throw new UserNotFoundException(userId);

        }

        BookDto[] books = restTemplate.getForObject(
                BOOK_SERVICE_BASE_URL + "/books?userId=" + userId, BookDto[].class);

        if (books == null) {
            books = new BookDto[0];
        }

        List<Map<String, String>> allBooks = Arrays.stream(books)
                .map(book -> Map.of("id", book.getId(), "name", book.getName()))
                .toList();

        int start = pageNum * pageSize;
        int end = Math.min(start + pageSize, allBooks.size());
        List<Map<String, String>> paginatedBooks = start >= allBooks.size()
                ? List.of()
                : allBooks.subList(start, end);

        Map<String, Object> userData = Map.of(
                "userId", user.getId(),
                "userName", user.getName(),
                "book", paginatedBooks
        );

        return new ResponseDto(allBooks.size(), pageNum + 1, List.of(userData));
    }
}
