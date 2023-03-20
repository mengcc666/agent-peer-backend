package hnu.csee.mengcc.agentpeer.user;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends MongoRepository<User, String> {
  List<User> findByEmail(@Param("email") String email);
}
