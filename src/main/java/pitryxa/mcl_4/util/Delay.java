package pitryxa.mcl_4.util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Delay {
    private final IntRandom intRandom;

    public void execute() {
        try {
            Thread.sleep(intRandom.generate());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
