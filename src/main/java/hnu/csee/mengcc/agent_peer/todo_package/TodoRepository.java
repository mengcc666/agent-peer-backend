package hnu.csee.mengcc.agent_peer.todo_package;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "todo", path = "todo")
public interface TodoRepository extends MongoRepository<Todo, String> {}
