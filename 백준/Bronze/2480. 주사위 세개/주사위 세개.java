import java.util.Scanner;

public class Main {

    public static void solution(int num1, int num2, int num3){

        // 3개의 주사위 수가 모두 일치 하는 경우, 일치하는 수를
        if (num1==num2 && num1==num3){
            System.out.println(10_000 + (num1) * 1_000);

        // 3개의 주사위 수가 모두 불일치하는 경우, 그중 가장 큰 수만
        }else if(num1!=num2 && num1 !=num3 && num2!=num3){

            int max;
            if(num1>= num2 && num1 >= num3){
                max = num1;
            }else if(num2>=num1 && num2 > num3){
                max = num2;
            }else {
                max = num3;
            }
            System.out.println((max * 100));
        }else{
            // 3개의 주사위 수가 2개의 수가 일치하는 경우
            if(num2 == num3){
                System.out.println(1_000 + (num2) * 100);
            }else{
                // num1 == num2 && num1 == num3 경우의 수
                System.out.println(1_000 + (num1) * 100);
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        solution(num1, num2, num3);
        scanner.close();
    }

}
