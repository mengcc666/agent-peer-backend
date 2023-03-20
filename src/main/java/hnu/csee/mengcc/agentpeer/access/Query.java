package hnu.csee.mengcc.agentpeer.access;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Query {
  static {
    System.setProperty(
      "org.hyperledger.fabric.sdk.service_discovery.as_localhost",
      "true"
    );
  }

  // helper function for getting connected to the gateway
  public static Gateway connect() throws Exception {
    // Load a file system based wallet for managing identities.
    Path walletPath = Paths.get("wallet");
    Wallet wallet = Wallets.newFileSystemWallet(walletPath);
    // load a CCP
    Path networkConfigPath = Paths.get(
      "..",
      "..",
      "test-network",
      "organizations",
      "peerOrganizations",
      "org1.example.com",
      "connection-org1.yaml"
    );

    Gateway.Builder builder = Gateway.createBuilder();
    builder
      .identity(wallet, "appUser")
      .networkConfig(networkConfigPath)
      .discovery(true);
    return builder.connect();
  }

  @GetMapping("/query")
  public String query() {
    return String.format("Invoke query()");
  }
}
