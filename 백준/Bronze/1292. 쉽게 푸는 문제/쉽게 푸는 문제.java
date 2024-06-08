import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 구간의 시작과 끝을 입력받습니다.
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();

        // 수열 생성
        ArrayList<Integer> sequence = generateSequence(1000);

        // 구간의 합 계산
        int result = sumOfSubsequence(sequence, A, B);

        // 결과 출력
        System.out.println(result);
    }

    // 주어진 limit까지 수열을 생성합니다.
    public static ArrayList<Integer> generateSequence(int limit) {
        ArrayList<Integer> sequence = new ArrayList<>();
        int num = 1;
        while (sequence.size() < limit) {
            for (int i = 0; i < num; i++) {
                sequence.add(num);
            }
            num++;
        }
        return sequence;
    }

    // 수열의 A번째부터 B번째까지의 합을 계산합니다.
    public static int sumOfSubsequence(ArrayList<Integer> sequence, int A, int B) {
        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += sequence.get(i);
        }
        return sum;
    }
}
