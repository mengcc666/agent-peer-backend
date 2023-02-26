package hnu.csee.mengcc.agent_peer;

import hnu.csee.mengcc.agent_peer.FunctionsRepo;
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
  }
  @GetMapping(value = "/hello")
  public String hello(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return String.format("Hello %s!", name);
  }

  @GetMapping(value = "/startNetwork")
  public void startNetwork() throws InterruptedException {
    String[] commands = { "./network.sh", "up" };
    String path = "/root/workspace/fabric-samples/test-network";
    FunctionsRepo f = new FunctionsRepo();
    f.InvokeCommandAtSpecifiedPath(commands, path);
  }

  @GetMapping(value = "/stopNetwork")
  public void stopNetwork() throws InterruptedException {
    String[] commands = { "./network.sh", "down" };
    String path = "/root/workspace/fabric-samples/test-network";
    FunctionsRepo f = new FunctionsRepo();
    f.InvokeCommandAtSpecifiedPath(commands, path);
  }
}
