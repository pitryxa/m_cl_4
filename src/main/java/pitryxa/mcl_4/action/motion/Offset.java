package pitryxa.mcl_4.action.motion;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.mouse.InitialMouseArea;
import pitryxa.mcl_4.util.IntRandom;

import java.awt.Point;

@Component
@RequiredArgsConstructor
public class Offset {
    private final InitialMouseArea initialMouseArea;

    @Qualifier("motionOffsetXIntRandom")
    private final IntRandom offsetXIntRandom;

    @Qualifier("motionOffsetYIntRandom")
    private final IntRandom offsetYIntRandom;

    public Point destination(Point current) {
        while (true) {
            int offsetX = offsetXIntRandom.generate();
            int offsetY = offsetYIntRandom.generate();
            Point destination = new Point(current.x + offsetX, current.y + offsetY);
            if (initialMouseArea.pointIn(destination)
                    || initialMouseArea.compareByProximity(destination, current) <= 0) {
                return destination;
            }
        }
    }
}
