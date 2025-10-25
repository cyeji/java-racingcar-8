package racingcar;

import java.util.ArrayList;
import java.util.List;

/**
 * 경주 자동차들 클래스
 */
public class RacingCars {
    private final List<RacingCar> cars = new ArrayList<>();

    public RacingCars(List<String> names) {
        for (String n : names) {
            cars.add(new RacingCar(n));
        }
    }

    /**
     * 경주 자동차 리스트 반환
     *
     * @return 경주 자동차 리스트
     */
    public List<RacingCar> getCars() {
        return cars;
    }

    /**
     * 한 라운드 실행
     */
    public void runRound() {
        for (RacingCar c : cars) {
            c.tryMove();
        }
    }

    /**
     * 우승자 이름 리스트 반환
     *
     * @return 우승자 이름 리스트
     */
    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (RacingCar c : cars) {
            if (c.getPosition() > max) {
                max = c.getPosition();
            }
        }
        for (RacingCar c : cars) {
            if (c.getPosition() == max) {
                winners.add(c.getName());
            }
        }
        return winners;
    }
}
