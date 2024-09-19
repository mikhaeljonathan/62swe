package sixtytwo.swe.skywalkingdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SkyWalking2RestController {

    @Value("${server4.port}")
    private String server4Port;

    @GetMapping("/api/62swe")
    public String hello() {
        String res = new RestTemplate().getForObject(
                "http://localhost:" + server4Port + "/api/likensubs", String.class);
        return res + "\n" + "Hello world from skywalking-demo-2";
    }
}
