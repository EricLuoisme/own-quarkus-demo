/*
 * Copyright 2018 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package own.quarkus.demo;

import jakarta.inject.Inject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
