package racingcar;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        RacingInputReader reader = new RacingInputReader();
        String[] names = reader.readNames();
        int tryCount = reader.readTryCount();

        RacingCars cars = new RacingCars(Arrays.asList(names));
        RacingCarPrinter printer = new RacingCarPrinter();

        for (int i = 0; i < tryCount; i++) {
            cars.runRound();
            printer.printRound(cars.getCars());
        }

        printer.printWinners(cars.getWinners());
    }
}
