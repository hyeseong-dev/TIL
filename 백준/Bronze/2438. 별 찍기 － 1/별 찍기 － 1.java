import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i = 1; i <= N; i++) {
            System.out.println(String.format("%s", "*").repeat(i));
        }
//        for(int row = 1; row <= N; row++) {
//
//            for(int col = 1; col <= row; col++) {
//                System.out.print("*");
//            }
//
//            for(int column = 0; column < N-row; column++) {
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
    }
}