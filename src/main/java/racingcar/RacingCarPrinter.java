package racingcar;

import java.util.List;

/**
 * 출력 클래스
 */
public class RacingCarPrinter {

    /**
     * 한 라운드 결과 출력
     *
     * @param cars 경주 자동차 리스트
     */
    public void printRound(List<RacingCar> cars) {
        for (RacingCar c : cars) {
            System.out.println(c.getName() + " : " + "-".repeat(c.getPosition()));
        }
        System.out.println();
    }

    /**
     * 최종 우승자 출력
     *
     * @param winners 우승자 이름 리스트
     */
    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
