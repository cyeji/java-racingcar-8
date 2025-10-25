package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 경주 자동차 클래스
 */
public class RacingCar {
    public static final int MOVING_THRESHOLD = 4;
    public static final int MAX_LENGTH = 9;
    public static final int MIN_LENGTH = 0;

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    /**
     * 이름 반환
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 현재 위치 반환
     *
     * @return
     */
    public int getPosition() {
        return position;
    }

    /**
     * 이동 시도
     */
    public void tryMove() {
        int r = Randoms.pickNumberInRange(MIN_LENGTH, MAX_LENGTH);
        if (r >= MOVING_THRESHOLD) {
            position++;
        }
    }
}
