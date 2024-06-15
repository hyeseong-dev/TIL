import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수를 입력받습니다.
        int[] testCases = new int[T];
        
        // 테스트 케이스들을 입력받습니다.
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
        }
        
        // 최대 n이 11이므로 dp 배열의 크기를 12로 설정합니다.
        int[] dp = new int[12];
        
        // 기본값 설정
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        // dp 배열 채우기
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[testCases[i]]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
