package sixtytwo.swe.skywalkingdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SkywalkingRestController {

    @Value("${server2.port}")
    private String server2Port;

    @Value("${server3.port}")
    private String server3Port;

    @GetMapping("/api")
    public String hello() {
        String res = new RestTemplate().getForObject(
                "http://localhost:" + server2Port + "/api/62swe", String.class);
        String res2 = new RestTemplate().getForObject(
                "http://localhost:" + server3Port + "/api/sixtytwoswe", String.class);
        System.out.println("Returning " + res + "\n" + res2);
        return res + "\n" + res2;
    }
}
