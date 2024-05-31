import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int recursiveCount = 0; // 코드1 실행 횟수 카운트
//    static int getRecursiveCount1 = 0;
//
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
//        int resultRecursive = fib(n);
//        int resultDP = fibonacci(n);

        System.out.println(fibonacci(n) + " " + (n-2)); // 코드1, 코드2 실행 횟수 출력
    }

    // 동적 프로그래밍을 이용하여 피보나치 수를 계산
    static int fibonacci(int N){
        int[] f = new int[N + 1];
        f[1] = f[2] = 1;
        for(int i = 3; i <= N; i++) { // 반복문을 통해 이전 값들을 이용하여 피보나치 수를 계산
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[N]; // 계산된 피보나치 수
    }

//    public static int fib(int n) {
//        if (n == 1 || n == 2) {
//            recursiveCount++; // 코드1 실행
//            return 1;
//        } else {
//            return fib(n - 1) + fib(n - 2);
//        }
//    }

//    public static int fibonacci(int n) {
//        int[] f = new int[n + 1];
//        f[1] = 1;
//        f[2] = 1;
//
//        for (int i = 3; i <= n; i++) {
//            getRecursiveCount1++;
//            f[i] = f[i - 1] + f[i - 2]; // 코드2
//        }
//
//        return f[n];
//    }
}
