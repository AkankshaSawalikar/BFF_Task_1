
package bff.bff_service.service;
import bff.bff_service.dto.BookDto;
import bff.bff_service.dto.ResponseDto;
import bff.bff_service.dto.UserDto;
import bff.bff_service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserBookService {

    @Autowired
    private RestTemplate restTemplate;

    private final String USER_SERVICE_BASE_URL = "http://localhost:8081";
    private final String BOOK_SERVICE_BASE_URL = "http://localhost:8082";

    public ResponseDto getUserBooks(String userId, Integer page, Integer size) {
        Integer pageNum = (page != null) ? page : 0;
        Integer pageSize = (size != null) ? size : 2;

        UserDto user = restTemplate.getForObject(USER_SERVICE_BASE_URL + "/users/" + userId, UserDto.class);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }

        // Use PageRequest to handle scalable pagination
        Pageable pageable = PageRequest.of(pageNum, pageSize);

        // Fetch books in a paginated manner
        ResponseEntity<List<BookDto>> booksResponse = restTemplate.exchange(
                BOOK_SERVICE_BASE_URL + "/books?userId=" + userId, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<BookDto>>() {});




        List<BookDto> books = booksResponse.getBody();
        if (books == null) {
            books = List.of();
        }

        List<Map<String, String>> paginatedBooks = books.stream()
                .skip(pageable.getOffset())
                .limit(pageable.getPageSize())
                .map(book -> Map.of("id", book.getId(), "name", book.getName()))
                .collect(Collectors.toList());


        int totalElements = books.size();
        int totalPages = (int) Math.ceil((double) totalElements / pageSize);

        // Prepare user data
        Map<String, Object> userData = Map.of(
                "userId", user.getId(),
                "userName", user.getName(),
                "book", paginatedBooks
        );

        return new ResponseDto(totalElements, pageNum + 1, List.of(userData));

    }
}
