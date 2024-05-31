import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.close();
        
        int[] combination = new int[M];
        generateCombinations(N, M, 1, 0, combination);
    }

    public static void generateCombinations(int N, int M, int start, int depth, int[] combination) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(combination[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            combination[depth] = i;
            generateCombinations(N, M, i + 1, depth + 1, combination);
        }
    }
}
