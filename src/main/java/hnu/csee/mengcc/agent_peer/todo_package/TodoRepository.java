package hnu.csee.mengcc.agent_peer.todo_package;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;
import org.springframework.data.repository.query.Param;


@RepositoryRestResource(collectionResourceRel = "todo", path = "todo")
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByDescLike(@Param("desc") String desc);
    List<Todo> findByCompleted(@Param("completed") Boolean completed);
}
