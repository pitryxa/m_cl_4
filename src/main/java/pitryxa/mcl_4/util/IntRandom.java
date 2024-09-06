package pitryxa.mcl_4.util;

import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class IntRandom {
    private final int startInclusive;
    private final int endExclusive;
    private final Random random;

    public int generate() {
        return random.nextInt(endExclusive - startInclusive) + startInclusive;
    }
}
