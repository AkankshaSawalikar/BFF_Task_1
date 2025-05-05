package user_service.user_service.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import user_service.user_service.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}