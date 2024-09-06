package pitryxa.mcl_4.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pitryxa.mcl_4.util.IntRandom;

import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class MotionConfiguration {
    private final Random random;

    @Value("${motion.offset.x}")
    private int maxOffsetX;

    @Value("${motion.offset.y}")
    private int maxOffsetY;

    @Bean("motionOffsetXIntRandom")
    public IntRandom getOffsetXIntRandom() {
        return new IntRandom(-maxOffsetX, maxOffsetX, random);
    }

    @Bean("motionOffsetYIntRandom")
    public IntRandom getOffsetYIntRandom() {
        return new IntRandom(-maxOffsetY, maxOffsetY, random);
    }
}
