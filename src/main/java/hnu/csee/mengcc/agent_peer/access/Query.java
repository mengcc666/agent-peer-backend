package hnu.csee.mengcc.agent_peer.access;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Query {
    @GetMapping("/query")
    public String query(){
        return String.format("Invoke query()");
    }
}
