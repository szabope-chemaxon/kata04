package hu.szabope;

import org.junit.Test;

import java.io.IOException;


public class TestEverythingEasily {

    @Test
    public void testNoArgs() throws IOException {
        Main.main(new String[] {});
    }

    @Test
    public void testWeather() throws IOException {
        Main.main(new String[] {"weather", "data/weather.dat"});
    }

    @Test
    public void testFootball() throws IOException {
        Main.main(new String[] {"football", "data/football.dat"});
    }
}
