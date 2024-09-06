package pitryxa.mcl_4.action.motion;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.mouse.Cursor;

import java.awt.Point;

@Component
@RequiredArgsConstructor
@Slf4j
public class Motion {
    private final Cursor cursor;
    private final Offset offset;

    @SneakyThrows
    public void execute() {
        Point current = cursor.current();
        Point destination = offset.destination(current);
        cursor.move(destination);
        log.info("Move to {}:{} from {}:{}", destination.x, destination.y, current.x, current.y);
    }
}
