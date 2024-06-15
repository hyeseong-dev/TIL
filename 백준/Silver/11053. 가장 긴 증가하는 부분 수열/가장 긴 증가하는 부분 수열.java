import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 수열 A의 크기 N 입력
        int N = scanner.nextInt();
        int[] A = new int[N];
        
        // 수열 A의 요소들 입력
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        // DP 배열 초기화
        int[] dp = new int[N];
        int maxLength = 1;  // LIS의 최소 길이는 1
        
        // DP 초기값 설정
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        
        // DP를 이용하여 LIS 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            // 현재까지의 최대 LIS 길이 업데이트
            if (maxLength < dp[i]) {
                maxLength = dp[i];
            }
        }
        
        // 결과 출력
        System.out.println(maxLength);
        
        scanner.close();
    }
}
