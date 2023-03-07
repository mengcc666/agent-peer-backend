package hnu.csee.mengcc.agent_peer.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>{
    List<User> findByUserEmail(@Param("userEmail") String userEmail);
}
