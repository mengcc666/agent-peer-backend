package hnu.csee.mengcc.agentpeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
public class AgentPeerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AgentPeerApplication.class, args);
    System.out.println("代理节点已启动");
  }

}
