package hnu.csee.mengcc.agentpeer.connecttofabric;

import org.hyperledger.fabric.gateway.*;
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
    static {
        System.setProperty("org.hyperledger.fabric.sdk.service_discovery.as_localhost", "false");
    }

    // helper function for getting connected to the gateway
    public static Gateway connect() throws Exception{
        // Load a file system based wallet for managing identities.
        Path walletPath = Paths.get("wallet");
        Wallet wallet = Wallets.newFileSystemWallet(walletPath);
        // load a CCP
        Path networkConfigPath = Paths.get("organizations", "peerOrganizations", "org1.example.com", "connection-org1.yaml");

        Gateway.Builder builder = Gateway.createBuilder();
        builder.identity(wallet, "appUser").networkConfig(networkConfigPath).discovery(true);
        return builder.connect();
    }

    @GetMapping("remote/enrollAdmin")
    public String enrollAdmin(){
        try{
            EnrollAdmin.enroll();
        }catch (Exception e){
            System.err.println(e);
        }
        return "Finish remote/enrollAdmin";
    }

    @GetMapping("remote/registerUser")
    public String registerUser(){
        try {
            RegisterUser.register();
        }catch (Exception e){
            System.err.println(e);
        }
        return "remote/registerUser";
    }

    @GetMapping("connect/invokeChaincode")
    public String invokeChaincode() {
        // connect to the network and invoke the smart contract
        try (Gateway gateway = connect()) {

            // get the network and contract
            Network network = gateway.getNetwork("mychannel");
//            System.out.println("mengcc : "+network.toString());
            Contract contract = network.getContract("basic");

            byte[] result;

//            System.out.println("Submit Transaction: InitLedger creates the initial set of assets on the ledger.");
//            contract.submitTransaction("InitLedger");
//
//            System.out.println("\n");
            result = contract.evaluateTransaction("GetAllAssets");
            System.out.println("Evaluate Transaction: GetAllAssets, result: " + new String(result));

//            System.out.println("\n");
//            System.out.println("Submit Transaction: CreateAsset asset13");
//            //CreateAsset creates an asset with ID asset13, color yellow, owner Tom, size 5 and appraisedValue of 1300
//            contract.submitTransaction("CreateAsset", "asset13", "yellow", "5", "Tom", "1300");
//
//            System.out.println("\n");
//            System.out.println("Evaluate Transaction: ReadAsset asset13");
//            // ReadAsset returns an asset with given assetID
//            result = contract.evaluateTransaction("ReadAsset", "asset13");
//            System.out.println("result: " + new String(result));
//
//            System.out.println("\n");
//            System.out.println("Evaluate Transaction: AssetExists asset1");
//            // AssetExists returns "true" if an asset with given assetID exist
//            result = contract.evaluateTransaction("AssetExists", "asset1");
//            System.out.println("result: " + new String(result));
//
//            System.out.println("\n");
//            System.out.println("Submit Transaction: UpdateAsset asset1, new AppraisedValue : 350");
//            // UpdateAsset updates an existing asset with new properties. Same args as CreateAsset
//            contract.submitTransaction("UpdateAsset", "asset1", "blue", "5", "Tomoko", "350");
//
//            System.out.println("\n");
//            System.out.println("Evaluate Transaction: ReadAsset asset1");
//            result = contract.evaluateTransaction("ReadAsset", "asset1");
//            System.out.println("result: " + new String(result));
//
//            try {
//                System.out.println("\n");
//                System.out.println("Submit Transaction: UpdateAsset asset70");
//                //Non existing asset asset70 should throw Error
//                contract.submitTransaction("UpdateAsset", "asset70", "blue", "5", "Tomoko", "300");
//            } catch (Exception e) {
//                System.err.println("Expected an error on UpdateAsset of non-existing Asset: " + e);
//            }
//
//            System.out.println("\n");
//            System.out.println("Submit Transaction: TransferAsset asset1 from owner Tomoko > owner Tom");
//            // TransferAsset transfers an asset with given ID to new owner Tom
//            contract.submitTransaction("TransferAsset", "asset1", "Tom");
//
//            System.out.println("\n");
//            System.out.println("Evaluate Transaction: ReadAsset asset1");
//            result = contract.evaluateTransaction("ReadAsset", "asset1");
//            System.out.println("result: " + new String(result));
        }
        catch(Exception e){
            System.err.println(e);
        }

        String str="invoke chaincode function";
        return str;
    }
}
