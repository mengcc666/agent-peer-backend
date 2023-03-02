package hnu.csee.mengcc.agent_peer.access;

@RestController
public class Query {
    @GetMapping("/query")
    public String query(){
        return String.format("Invoke query()");
    }
}
