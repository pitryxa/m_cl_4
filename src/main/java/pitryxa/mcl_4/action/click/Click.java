package pitryxa.mcl_4.action.click;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.mouse.Cursor;
import pitryxa.mcl_4.util.Delay;
import pitryxa.mcl_4.mouse.InitialMouseArea;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class Click {
    private final Cursor cursor;
    private final InitialMouseArea initialMouseArea;
    @Qualifier("clickDelayRelease")
    private final Delay delayRelease;
    @Qualifier("clickDelayClick")
    private final Delay delayClick;
    private final Count count;
    private final Robot robot;

    public void execute() {
        Point current = cursor.current();
        if (initialMouseArea.pointOut(current)) {
            return;
        }
        delayClick.execute();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        delayRelease.execute();
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        log.info("Click {}", count.inc());
    }
}
