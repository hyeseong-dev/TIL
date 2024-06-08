import java.util.Scanner;

public class Main {
    /**
     * [시간복잡도]
     * 이 코드의 시간 복잡도는 주어진 참가자의 수를 (N)이라고 할 때, O(N) 입니다.
     * 왜냐하면 코드는 각 참가자에 대해 두 번의 런과 다섯 번의 트릭 점수를 읽고,
     * 그 정보를 기반으로 최대 점수를 계산하는 데에 반복문을 사용하고 있기 때문입니다.
     * <p>
     * 걸국 : 입력된 참가자의 수에 비례하여 코드가 실행되므로, 시간 복잡도는( O(N) )이 됩니다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int maxScore = Integer.MIN_VALUE; // 최고 점수를 저장할 변수 초기화

        for (int i = 0; i < N; i++) { // 각 참가자에 대한 반복문 시작
            int run1 = scanner.nextInt(); // 첫 번째 런 점수 입력
            int run2 = scanner.nextInt(); // 두 번째 런 점수 입력
            int maxRun = Math.max(run1, run2); // 두 런 중 최고 점수 계산

            int maxTrick = Integer.MIN_VALUE; // 트릭 중 최고 점수를 저장할 변수 초기화
            int secondMaxTrick = Integer.MIN_VALUE; // 두 번째로 높은 트릭 점수를 저장할 변수 초기화

            for (int j = 0; j < 5; j++) { // 다섯 번의 트릭 점수 입력을 위한 반복문 시작
                int trick = scanner.nextInt(); // 트릭 점수 입력
                if (trick > maxTrick) { // 현재 트릭 점수가 최고 점수보다 큰 경우
                    secondMaxTrick = maxTrick; // 두 번째로 높은 점수를 최고 점수로 갱신
                    maxTrick = trick; // 최고 점수를 현재 트릭 점수로 갱신
                } else if (trick > secondMaxTrick) { // 현재 트릭 점수가 두 번째로 높은 점수보다 큰 경우
                    secondMaxTrick = trick; // 두 번째로 높은 점수를 현재 트릭 점수로 갱신
                }
            } // 다섯 번의 트릭 점수 입력을 위한 반복문 종료

            int totalScore = maxRun + maxTrick + secondMaxTrick; // 최종 점수 계산
            maxScore = Math.max(maxScore, totalScore); // 최고 점수 갱신
        } // 각 참가자에 대한 반복문 종료

        System.out.println(maxScore);
        scanner.close();
    }
}
