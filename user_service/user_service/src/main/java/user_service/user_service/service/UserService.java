package user_service.user_service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_service.user_service.dto.UserDto;
import user_service.user_service.model.User;
import user_service.user_service.repository.UserRepository;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUserFromDto(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        return userRepository.save(user);
    }


    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
}
