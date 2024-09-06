package pitryxa.mcl_4.action.click;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Count {
    private long count;

    public long inc() {
        return ++count;
    }
}
