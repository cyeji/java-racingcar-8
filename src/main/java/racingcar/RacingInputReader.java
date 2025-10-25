package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 경주 입력 읽기 클래스
 */
public class RacingInputReader {

    /**
     * 경주할 자동차 이름 읽기
     *
     * @return 경주할 자동차 이름 배열
     */
    public String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        String[] parts = line.split(",");
        List<String> names = new ArrayList<>();
        for (String p : parts) {
            String t = p.trim();
            if (t.isEmpty() || t.length() > 5) {
                throw new IllegalArgumentException();
            }
            names.add(t);
        }
        return names.toArray(new String[0]);
    }

    /**
     * 시도할 횟수 읽기
     *
     * @return 시도할 횟수
     */
    public int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String line = Console.readLine();
        try {
            int v = Integer.parseInt(line);
            if (v <= 0) {
                throw new IllegalArgumentException();
            }
            return v;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
