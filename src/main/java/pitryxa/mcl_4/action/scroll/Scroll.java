package pitryxa.mcl_4.action.scroll;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.util.BooleanRandom;
import pitryxa.mcl_4.util.Delay;

import java.awt.Robot;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@Slf4j
public class Scroll {
    @Qualifier("scrollDelay")
    private final Delay delay;
    private final ScrollNumber scrollNumber;
    private final Robot robot;
    private final BooleanRandom booleanRandom;

    public void execute() {
        int direction = booleanRandom.generate() ? 1 : -1;
        int number = scrollNumber.generate();
        IntStream.range(0, number).forEach(i -> {
            robot.mouseWheel(direction);
            delay.execute();
        });
        log.info("Scroll {}", number);
    }
}
