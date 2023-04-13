package hnu.csee.mengcc.agentpeer.connecttofabric;

import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author Mengcc
 * @Date 2023/4/12 10:16
 * @Version 1.0
 */

@RestController
public class Connect {

    // helper function for getting connected to the gateway
    public static Gateway connect() throws Exception{
        // Load a file system based wallet for managing identities.
        String peerAddress="101.34.79.126:7051";
        Path walletPath = Paths.get("wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletPath);
        // load a CCP
        Path networkConfigPath = Paths.get( "..", "organizations", "peerOrganizations", "org1.example.com", "connection-org1.yaml");

        Gateway.Builder builder = Gateway.createBuilder();
        builder.identity(wallet, "appUser").networkConfig(networkConfigPath).discovery(false);
        return builder.connect();
    }

    @GetMapping("connect/invokeChaincode")
    public String invokeChaincode(){
        try {
            EnrollAdmin.enrollAdmin();
//            RegisterUser.main(null);
        } catch (Exception e) {
            System.err.println(e);
        }

        String str="invoke chaincode function";
        return str;
    }
}
