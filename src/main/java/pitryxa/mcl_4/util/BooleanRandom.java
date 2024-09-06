package pitryxa.mcl_4.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class BooleanRandom {

    private final Random rand;

    public boolean generate() {
        return rand.nextBoolean();
    }
}
