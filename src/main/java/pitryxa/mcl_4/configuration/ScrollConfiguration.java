package pitryxa.mcl_4.configuration;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pitryxa.mcl_4.util.Delay;
import pitryxa.mcl_4.util.IntRandom;

import java.awt.Robot;
import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class ScrollConfiguration {
    private final Random random;

    @Value("${scroll.delay.min}")
    private int delayMin;

    @Value("${scroll.delay.max}")
    private int delayMax;

    @Value("${scroll.min}")
    private int minScroll;

    @Value("${scroll.max}")
    private int maxScroll;

    @Bean
    public IntRandom getDelayIntRandom() {
        return new IntRandom(delayMin, delayMax, random);
    }

    @Bean("scrollIntRandom")
    public IntRandom getScrollIntRandom() {
        return new IntRandom(minScroll, maxScroll, random);
    }

    @Bean("scrollDelay")
    public Delay getDelay() {
        return new Delay(getDelayIntRandom());
    }

    @Bean
    @SneakyThrows
    public Robot getRobot() {
        return new Robot();
    }
}
