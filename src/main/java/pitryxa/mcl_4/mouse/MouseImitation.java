package pitryxa.mcl_4.mouse;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MouseImitation {
    private final Mouse mouse;

    @Value("${iteration.count}")
    private int iterationCount;

    @PostConstruct
    public void start() {
        for (int i = 0; i < iterationCount; i++) {
            mouse.scroll();
            mouse.move();
            mouse.click();
        }
    }
}
