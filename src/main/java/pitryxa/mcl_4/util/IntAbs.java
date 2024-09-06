package pitryxa.mcl_4.util;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IntAbs {
    private final int n;

    public int value() {
        return n < 0 ? -n : n;
    }
}
