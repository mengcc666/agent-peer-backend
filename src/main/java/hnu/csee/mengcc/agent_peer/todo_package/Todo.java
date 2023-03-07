package hnu.csee.mengcc.agent_peer.todo_package;

import org.springframework.data.annotation.Id;
import hnu.csee.mengcc.agent_peer.user.User;

public class Todo {
  @Id
  private String id;
  private String desc;
  private boolean completed;

  private User user;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public User getUser(){
    return user;
  }

  public void setUser(User user){
    this.user=user;
  }
}
