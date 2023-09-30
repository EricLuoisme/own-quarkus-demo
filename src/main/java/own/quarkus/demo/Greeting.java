package own.quarkus.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class Greeting {
    private final String message;
}
