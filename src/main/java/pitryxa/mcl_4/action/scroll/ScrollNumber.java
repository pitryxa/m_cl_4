package pitryxa.mcl_4.action.scroll;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pitryxa.mcl_4.util.IntRandom;

@Component
@RequiredArgsConstructor
public class ScrollNumber {

    @Qualifier("scrollIntRandom")
    private final IntRandom intRandom;

    public int generate() {
        int scrollNumber;
        while ((scrollNumber = intRandom.generate()) == 0) {
        }
        return scrollNumber;
    }
}
