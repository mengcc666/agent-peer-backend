package hnu.csee.mengcc.agentpeer.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicOperation {

  @GetMapping("user")
  public String helloUser() {
      return "Hello User";
  }

  @GetMapping("admin")
  public String helloAdmin() {
      return "Hello Admin";
  }

  @GetMapping(value = "/hello")
  public String hello(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return String.format("Hello %s", name);
  }

  @GetMapping(value = "/startNetwork")
  public void startNetwork() throws InterruptedException {
    String[] commands = { "./network.sh", "up" };
    String path = "/root/workspace/fabric-samples/test-network";
    FunctionsRepo f = new FunctionsRepo();
    f.InvokeCommandAtSpecifiedPath(commands, path);
  }

  @GetMapping(value = "/initCA")
  public void initCA() throws InterruptedException {
    String[] commands = { "./network.sh", "up", "-ca" };
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

  @GetMapping(value = "/createChannel")
  public void createChannel(
    @RequestParam(value = "name", defaultValue = "mychannel") String channelName
  ) throws InterruptedException {
    //./network.sh up createChannel -c mychannel -ca
    String[] commands = {
      "./network.sh",
      "createChannel",
      "-c",
      channelName,
      "-ca",
    };
    String path = "/root/workspace/fabric-samples/test-network";
    FunctionsRepo f = new FunctionsRepo();
    f.InvokeCommandAtSpecifiedPath(commands, path);
  }

  @GetMapping(value = "/getBlockchainNetworkInfo")
  public void getBlockchainNetworkInfo() throws InterruptedException {
    String[] commands = { "docker", "ps", "-a" };
    String path = "/root";
    FunctionsRepo f = new FunctionsRepo();
    f.InvokeCommandAtSpecifiedPath(commands, path);
  }

  @GetMapping(value = "/deployChaincode")
  public void deployChaincode(
    @RequestParam(
      value = "chaincodeName",
      defaultValue = "basic"
    ) String chaincodeName,
    @RequestParam(
      value = "chaincodePath",
      defaultValue = "../asset-transfer-basic/chaincode-javascript/"
    ) String chaincodePath,
    @RequestParam(
      value = "chaincodeLanguage",
      defaultValue = "javascript"
    ) String chaincodeLanguage
  ) throws InterruptedException {
    //./network.sh deployCC -ccn basic -ccp ../asset-transfer-basic/chaincode-javascript/ -ccl javascript
    String[] commands = {
      "./network.sh",
      "deployCC",
      "-ccn",
      chaincodeName,
      "-ccp",
      chaincodePath,
      "-ccl",
      chaincodeLanguage,
    };
    String path = "/root/workspace/fabric-samples/test-network";
    FunctionsRepo f = new FunctionsRepo();
    f.InvokeCommandAtSpecifiedPath(commands, path);
  }
}
