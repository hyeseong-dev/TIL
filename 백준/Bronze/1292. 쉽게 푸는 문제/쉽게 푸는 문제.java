import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 구간의 시작과 끝을 입력받습니다.
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.close();

        // 구간의 합 계산
        int result = sumOfSubsequence(A, B);

        // 결과 출력
        System.out.println(result);
    }

    // 수열의 A번째부터 B번째까지의 합을 계산합니다.
    public static int sumOfSubsequence(int A, int B) {
        int sum = 0;
        int count = 0;
        int number = 1;

        // B까지의 숫자들의 합을 구합니다.
        for (int i = 1; count < B; i++) {
            for (int j = 0; j < i; j++) {
                count++;
                if (count >= A && count <= B) {
                    sum += i;
                }
                if (count == B) {
                    break;
                }
            }
        }
        return sum;
    }
}
