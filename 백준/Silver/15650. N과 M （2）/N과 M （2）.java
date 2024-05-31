import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();
        
        generateCombinations(N, M);
    }

    public static void generateCombinations(int N, int M) {
        // DP table to store combinations
        int[][] dp = new int[N + 1][M + 1];

        // Initialize the DP table
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= Math.min(i, M); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        // Array to store the current combination
        int[] combination = new int[M];
        printCombinations(dp, N, M, 0, 1, combination);
    }

    public static void printCombinations(int[][] dp, int N, int M, int index, int start, int[] combination) {
        if (index == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(combination[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (dp[N - i][M - index - 1] > 0) {
                combination[index] = i;
                printCombinations(dp, N, M, index + 1, i + 1, combination);
            }
        }
    }
}
