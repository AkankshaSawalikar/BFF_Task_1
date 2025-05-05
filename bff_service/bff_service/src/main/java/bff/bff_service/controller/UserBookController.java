package bff.bff_service.controller;
import bff.bff_service.dto.BookDto;
import bff.bff_service.dto.UserDto;
import bff.bff_service.dto.ResponseDto;
import bff.bff_service.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserBookController {

    @Autowired
    private UserBookService userBookService;

    @GetMapping("/user-books/{userId}")
    public ResponseDto getUserBooks(
            @PathVariable String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return userBookService.getUserBooks(userId, page, size);
    }
}
