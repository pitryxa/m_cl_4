package pitryxa.mcl_4.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pitryxa.mcl_4.action.click.Count;
import pitryxa.mcl_4.util.Delay;
import pitryxa.mcl_4.util.IntRandom;

import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class ClickConfiguration {
    private final Random random;

    @Value("${click.delay.release.min}")
    private int delayReleaseMin;

    @Value("${click.delay.release.max}")
    private int delayReleaseMax;

    @Value("${click.delay.click.min}")
    private int delayClickMin;

    @Value("${click.delay.click.max}")
    private int delayClickMax;

    @Bean
    public IntRandom getDelayReleaseIntRandom() {
        return new IntRandom(delayReleaseMin, delayReleaseMax, random);
    }

    @Bean
    public IntRandom getDelayClickIntRandom() {
        return new IntRandom(delayClickMin, delayClickMax, random);
    }

    @Bean("clickDelayRelease")
    public Delay getDelayRelease() {
        return new Delay(getDelayReleaseIntRandom());
    }

    @Bean("clickDelayClick")
    public Delay getDelayClick() {
        return new Delay(getDelayClickIntRandom());
    }

    @Bean
    public Count getClickCount() {
        return new Count(0);
    }
}
