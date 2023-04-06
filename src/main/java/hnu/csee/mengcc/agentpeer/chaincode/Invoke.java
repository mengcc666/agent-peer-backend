package hnu.csee.mengcc.agentpeer.chaincode;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Invoke {
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
      "/root/workspace/fabric-samples",
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

  @GetMapping
  public void invokeChaincode(
    @RequestParam(
      value = "contractName",
      defaultValue = "basic"
    ) String contractName,
    @RequestParam(value = "transactionName") String transactionName
  ) {
    // enrolls the admin and registers the user
    try {
      EnrollAdmin.main(null);
      RegisterUser.main(null);
    } catch (Exception e) {
      System.err.println(e);
    }

    // connect to the network and invoke the smart contract
    try (Gateway gateway = connect()) {
      // get the network and contract
      Network network = gateway.getNetwork("mychannel");
      Contract contract = network.getContract(contractName);

      byte[] result;

      System.out.println(
        "Submit Transaction: InitLedger creates the initial set of assets on the ledger."
      );
      contract.submitTransaction("InitLedger");

      System.out.println("\n");
      result = contract.evaluateTransaction("GetAllAssets");
      System.out.println(
        "Evaluate Transaction: GetAllAssets, result: " + new String(result)
      );
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
