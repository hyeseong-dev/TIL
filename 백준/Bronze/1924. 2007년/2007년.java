import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        solution(num1, num2);
        scanner.close();
    }

    private static void solution(int num1, int num2) {
        LocalDate date = LocalDate.of(2007, num1, num2);
        System.out.println(date.getDayOfWeek().toString().substring(0, 3));
    }
}
