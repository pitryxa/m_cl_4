package pitryxa.mcl_4;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.mouse.MouseImitation;

@Component
@RequiredArgsConstructor
public class ApplicationStarter {

    private final MouseImitation mouseImitation;

    @EventListener
    public void start(ContextRefreshedEvent event) {
        mouseImitation.start();
    }
}
