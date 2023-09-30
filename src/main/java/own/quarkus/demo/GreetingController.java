package own.quarkus.demo;

import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * After using mvn install -> we could get a quarkus-run.jar file
 * with cmd: java -jar ./target/quarkus-app/quarkus-run.jar
 * we can find out that this compiled jar running super fast
 */
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // can use @Inject to replace @Autowired in specific situation
    @Inject
    private GreetingBean greetingBean;

//    public GreetingController(GreetingBean greetingBean) {
//        this.greetingBean = greetingBean;
//    }

    @GetMapping("/{name}")
    public Greeting hello(@PathVariable(name = "name") String name) {
        return new Greeting(greetingBean.greet(name));
    }
}
