package sixtytwo.swe.skywalkingdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkyWalking3RestController {

    @GetMapping("/api/sixtytwoswe")
    public String hello() {
        return "Hello world from skywalking-demo-3!";
    }
}
