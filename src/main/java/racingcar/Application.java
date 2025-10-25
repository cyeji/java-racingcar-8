package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] racingCars = Console.readLine().split(",");
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        Queue<RacingCarCount> queue = new LinkedList<>();
        for (String racingCar : racingCars) {
            queue.offer(new RacingCarCount(racingCar, 0));
        }

        for (int i = 0; i < tryCount; i++) {
            int size = queue.size();
            while (size != 0) {
                RacingCarCount poll = queue.poll();
                int count = poll.count;
                int randomCount = Randoms.pickNumberInRange(0, 9);
                if (randomCount >= 4) {
                    System.out.println(poll.name + " : " + "-".repeat(count + 1));
                    queue.offer(new RacingCarCount(poll.name, count + 1));
                } else {
                    System.out.println(poll.name + " : " + "-".repeat(count));
                    queue.offer(new RacingCarCount(poll.name, count));
                }
                size--;
            }
            System.out.println();
        }

        List<RacingCarCount> list = new ArrayList<>(queue);
        Collections.sort(list);

        StringBuilder result = new StringBuilder();
        int max = Integer.MIN_VALUE;
        for (RacingCarCount racingCarCount1 : list) {
            if (racingCarCount1.count >= max) {
                result.append(racingCarCount1.name);
                max = racingCarCount1.count;
                result.append(",");
            }
        }
        result.deleteCharAt(result.length() - 1);

        System.out.println("최종 우승자 : " + result);

    }

    public static class RacingCarCount implements Comparable<RacingCarCount> {
        private String name;
        private int count;

        public RacingCarCount(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(RacingCarCount o) {
            return o.count - this.count;
        }
    }
}
