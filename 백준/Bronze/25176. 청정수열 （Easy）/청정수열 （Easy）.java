import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int a = 1;
        for (int i = 1; i <= n; i++) {
            a *= i;
        }

        System.out.println(a);
    }
}
