package pitryxa.mcl_4.mouse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.util.Distance2D;
import pitryxa.mcl_4.util.IntAbs;

import java.awt.Point;

@Component
@RequiredArgsConstructor
public class InitialMouseArea {
    private final Point initial;

    @Value("${initial.area.size}")
    private int size;

    public int compareByProximity(Point p1, Point p2) {
        double distance1 = new Distance2D(p1, initial).value();
        double distance2 = new Distance2D(p2, initial).value();
        return Double.compare(distance1, distance2);
    }

    public boolean pointIn(Point point) {
        int offsetX = new IntAbs(point.x - initial.x).value();
        int offsetY = new IntAbs(point.y - initial.y).value();
        return offsetX <= size
                && offsetY <= size;
    }

    public boolean pointOut(Point point) {
        return !pointIn(point);
    }
}
