package hnu.csee.mengcc.agentpeer.basic;

/**
 * @Author Mengcc
 * @Date 2023/4/23 10:40
 * @Version 1.0
 */


import hnu.csee.mengcc.agentpeer.basic.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
