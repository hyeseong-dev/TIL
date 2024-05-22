import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
       // Scanner를 이용해 입력을 받음
        Scanner scanner = new Scanner(System.in);

        // 두 정수를 입력받음
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // 형식에 맞게 출력
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Scanner 자원 해제
        scanner.close();
    }
}