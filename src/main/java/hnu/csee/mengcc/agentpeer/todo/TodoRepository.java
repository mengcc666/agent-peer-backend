package hnu.csee.mengcc.agentpeer.todo_package;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "todo", path = "todo")
public interface TodoRepository extends MongoRepository<Todo, String> {
  List<Todo> findByDescLike(@Param("desc") String desc);
  List<Todo> findByCompleted(@Param("completed") Boolean completed);
}
