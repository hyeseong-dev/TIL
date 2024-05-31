import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int recursiveCount = 0; // 코드1 실행 횟수 카운트

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //Int
        int resultRecursive = fib(n);
        int resultDP = fibonacci(n);

        System.out.println(recursiveCount + " " + (n - 2)); // 코드1, 코드2 실행 횟수 출력
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            recursiveCount++; // 코드1 실행
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2]; // 코드2
        }

        return f[n];
    }
}
