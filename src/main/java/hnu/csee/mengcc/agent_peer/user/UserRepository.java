package hnu.csee.mengcc.agent_peer.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends MongoRepository<User,String>{
    List<User> findByUserEmail(@Param("userEmail") String userEmail);
}
