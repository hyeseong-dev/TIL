import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of participants
        int N = scanner.nextInt();

        // Iterate through each participant
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            // Scores for two runs and five tricks
            int run1 = scanner.nextInt();
            int run2 = scanner.nextInt();
            int[] tricks = new int[5];
            for (int j = 0; j < 5; j++) {
                tricks[j] = scanner.nextInt();
            }

            // Calculate top 3 scores
            int maxRun = Math.max(run1, run2);
            int maxTrick = Integer.MIN_VALUE;
            int secondMaxTrick = Integer.MIN_VALUE;
            for (int trick : tricks) {
                if (trick > maxTrick) {
                    secondMaxTrick = maxTrick;
                    maxTrick = trick;
                } else if (trick > secondMaxTrick) {
                    secondMaxTrick = trick;
                }
            }

            // Calculate total score
            int totalScore = maxRun + maxTrick + secondMaxTrick;
            maxScore = Math.max(maxScore, totalScore);
        }

        // Print the maximum score
        System.out.println(maxScore);

        scanner.close();
    }
}
