package pitryxa.mcl_4.mouse;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.Point;

@Component
@RequiredArgsConstructor
public class Cursor {
    private final MouseMotionFactory motionFactory;

    public Point current() {
        return motionFactory.getMouseInfo().getMousePosition().getLocation();
    }

    public void move(Point p) throws InterruptedException {
        motionFactory.move(p.x, p.y);
    }
}
