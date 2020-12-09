package demo;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import sdu.beermachine.Read;
import sdu.beermachine.Write;

@Controller
public class WebController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }


}
