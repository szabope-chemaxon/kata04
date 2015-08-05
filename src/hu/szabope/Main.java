package hu.szabope;

import hu.szabope.data.DataFile;
import hu.szabope.data.FootballDataFile;
import hu.szabope.data.WeatherDataFile;

import java.io.IOException;

public class Main {

    private static final String FOOTBALL = "football";
    private static final String WEATHER = "weather";

    public static void main(String[] args) throws IOException {
	    if (!validArgs(args)) {
            printHelp();
            return;
        }

        DataFile dataFile = args[0].equals(WEATHER) ? new WeatherDataFile(args[1]) : new FootballDataFile(args[1]);
        System.out.println(dataFile.getSmallestSpreadIdentity());
    }

    private static boolean validArgs(String[] args) {
        return args.length == 2 && (args[0].equals(FOOTBALL) || args[0].equals(WEATHER));
    }

    private static void printHelp() {
        System.out.println("Usage: java -jar WeatherTest.jar [football|weather] path_to_data_file");
        System.out.println("Data file example: weather.dat, football.dat");
    }
}
