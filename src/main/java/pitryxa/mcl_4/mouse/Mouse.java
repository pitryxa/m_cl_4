package pitryxa.mcl_4.mouse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.util.BooleanRandom;
import pitryxa.mcl_4.action.click.Click;
import pitryxa.mcl_4.action.motion.Motion;
import pitryxa.mcl_4.action.scroll.Scroll;

@Component
@RequiredArgsConstructor
public class Mouse {
    private final Motion motion;
    private final Scroll scroll;
    private final Click click;
    private final BooleanRandom booleanRandom;

    public void click() {
        if (booleanRandom.generate()) {
            click.execute();
        }
    }

    public void move() {
        if (booleanRandom.generate()) {
            motion.execute();
        }
    }

    public void scroll() {
        if (booleanRandom.generate()) {
            scroll.execute();
        }
    }
}
