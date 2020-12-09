package demo.api;

import demo.service.SetValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InputValuesController {

    @GetMapping("/setmachinespeed")
    public String setMachineSpeed(@RequestParam float machineSpeed) {
        SetValues o = new SetValues();
        o.setMachSpeed(machineSpeed);
        return "index";
    }

    @GetMapping("/setproductamount")
    public String setProductAmount(@RequestParam float productAmount) {
        SetValues o = new SetValues();
        o.setProductAmount(productAmount);
        return "index";
    }

    @GetMapping("/setproducttype")
    public String setProductType(@RequestParam float productType) {
        SetValues o = new SetValues();
        o.setProductType(productType);
        return "index";
    }

    @GetMapping("/setcntrlcmd")
    public String setCntrlCmd(@RequestParam int cntrlcmd) {
        SetValues o = new SetValues();
        o.setCntrlCmd(cntrlcmd);
        return "index";
    }
}
