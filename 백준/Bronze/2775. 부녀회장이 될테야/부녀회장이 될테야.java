import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 아파트 층수와 호수를 위한 DP 테이블
        int[][] people = new int[15][15];

        // 0층 초기화
        for (int i = 1; i <= 14; i++) {
            people[0][i] = i;
        }

        // DP 테이블 채우기
        for (int k = 1; k <= 14; k++) {
            for (int n = 1; n <= 14; n++) {
                people[k][n] = 0;
                for (int j = 1; j <= n; j++) {
                    people[k][n] += people[k-1][j];
                }
            }
        }

        // 입력 받기
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(people[k][n]);
        }

        scanner.close();
    }
}
