package pl.fintech.metissociallending.metissociallendingservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ExampleController {

    @GetMapping
    public String example() {
        return "Hello FinTech!";
    }

}
