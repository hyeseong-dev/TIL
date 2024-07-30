import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            int C = scanner.nextInt(); // 거스름돈 (센트 단위)
            
            int quarter = 25;
            int dime = 10;
            int nickel = 5;
            int penny = 1;

            int quarterCount = C / quarter;
            C %= quarter;

            int dimeCount = C / dime;
            C %= dime;

            int nickelCount = C / nickel;
            C %= nickel;

            int pennyCount = C / penny;

            System.out.println(quarterCount + " " + dimeCount + " " + nickelCount + " " + pennyCount);
        }

        scanner.close();
    }
}