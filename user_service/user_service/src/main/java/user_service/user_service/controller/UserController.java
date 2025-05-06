
package user_service.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_service.user_service.dto.UserDto;
import user_service.user_service.model.User;
import user_service.user_service.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = userService.createUserFromDto(userDto);
        return new ResponseEntity<>(convertToDto(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(convertToDto(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    private UserDto convertToDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}
