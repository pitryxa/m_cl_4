package pitryxa.mcl_4.configuration;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.support.ScreenAdjustedNature;
import com.github.joonasvali.naturalmouse.util.FactoryTemplates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

@Configuration
public class CommonConfiguration {

    @Value("${screen.width}")
    private int defaultWidth;

    @Value("${screen.height}")
    private int defaultHeight;

    @Bean
    public MouseMotionFactory getMotionFactory() {
        GraphicsDevice[] screenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        Integer width = Arrays.stream(screenDevices)
                .map(GraphicsDevice::getDisplayMode)
                .map(DisplayMode::getWidth)
                .reduce(Integer::sum)
                .orElse(defaultWidth);
        Integer height = Arrays.stream(screenDevices)
                .map(GraphicsDevice::getDisplayMode)
                .map(DisplayMode::getHeight)
                .min(Comparator.comparingInt(Integer::intValue))
                .orElse(defaultHeight);
        ScreenAdjustedNature nature = new ScreenAdjustedNature(
                new Dimension(width, height),
                new Point(0, 0)
        );
        return FactoryTemplates.createAverageComputerUserMotionFactory(nature);
    }

    @Bean
    public Point getInitialPoint() {
        return getMotionFactory().getMouseInfo().getMousePosition().getLocation();
    }

    @Bean
    public Random getRandom() {
        return new Random();
    }
}
