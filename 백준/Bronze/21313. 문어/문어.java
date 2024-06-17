import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // 결과를 저장할 배열
        int[] ans = new int[n];

        // n이 짝수일 경우
        for (int i = 0; i < n / 2; i++) {
            ans[2 * i] = 1;
            ans[2 * i + 1] = 2;
        }

        // n이 홀수일 경우 마지막 요소 처리
        if (n % 2 != 0) {
            ans[n - 1] = 3;
        }

        // 결과 출력
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
