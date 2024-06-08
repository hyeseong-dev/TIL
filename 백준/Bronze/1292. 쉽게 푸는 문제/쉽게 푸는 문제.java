
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

/*
        [시간 복잡도] : O(N^2)
 */

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
/*
        1. 이 메소드는 수열의 크기 limit까지 생성합니다.
        2. 내부 루프에서 num이 증가할 때마다 해당 숫자를 num번 추가합니다.
        3. 결과적으로 전체 수열의 크기가 N일 때, 1 + 2 + 3 + ... + k가 N과 대략 같아야 합니다. 이는 대략적으로 k^2이 N에 비례하는 것을 의미합니다.
        4. 따라서, 이 메소드의 시간 복잡도는 O(N^2)입니다.
*/
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
/*
    1. 이 메소드는 주어진 구간 [A, B]의 합을 계산합니다.
    2. 이 경우 시간 복잡도는 O(B - A)로, 최악의 경우 O(N)입니다.

 */
        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += sequence.get(i);
        }
        return sum;
    }
}
