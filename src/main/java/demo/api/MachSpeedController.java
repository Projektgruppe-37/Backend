package demo.api;

import demo.service.MachSpeedTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sdu.beermachine.Write;

@Controller
public class MachSpeedController {

    @GetMapping("/setmachinespeed")
    public String setMachineSpeed(@RequestParam String machineSpeed) {
        float machSpeed = Float.parseFloat(machineSpeed);
        MachSpeedTest o = new MachSpeedTest();
        o.setMachSpeed(machSpeed);
        return "index";
    }

    @GetMapping("/getmachinespeed")
    public String getMachineSpeed() {
        MachSpeedTest o = new MachSpeedTest();
        System.out.println(o.getMachSpeed());
        o.getMachSpeed();
        return "index";
    }

}
