import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int[] results = new int[T];

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[][] stickers = new int[2][n];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    stickers[i][j] = scanner.nextInt();
                }
            }

            results[t] = getMaxStickerScore(n, stickers);
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int getMaxStickerScore(int n, int[][] stickers) {
        if (n == 0) return 0;

        int[][] dp = new int[2][n];

        dp[0][0] = stickers[0][0];
        dp[1][0] = stickers[1][0];

        if (n > 1) {
            dp[0][1] = stickers[1][0] + stickers[0][1];
            dp[1][1] = stickers[0][0] + stickers[1][1];
        }

        for (int j = 2; j < n; j++) {
            dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
            dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
