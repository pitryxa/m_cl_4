package pitryxa.mcl_4.util;

import lombok.RequiredArgsConstructor;

import java.awt.Point;

@RequiredArgsConstructor
public class Distance2D {
    private final Point p1;
    private final Point p2;

    public double value() {
        int dX = p1.x - p2.x;
        int dY = p1.y - p2.y;
        return Math.sqrt(dX * dX + dY * dY);
    }
}
