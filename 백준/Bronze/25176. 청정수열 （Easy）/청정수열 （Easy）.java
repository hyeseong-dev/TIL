// 메모리 : 17724
// 시간 : 208


// 시간 복잡도: O(N)
// N에 따라서 반복문이 실행되는 횟수가 결정되므로 시간 복잡도는 O(N)입니다.

import java.util.Scanner;

/*
    [핵심]
        1. 최소 순열의 개수를 구하는 것이 목적이다.
        2. `힌트`를 보고 1 사이의 값, 2사이의 값, 3사이의 값, 4사이의 값....을 구하는 순간 낚이는거
        3. 예를들어 {1,1,2,2,3,3}이 최소 순열이다.
            - 편의상 112233으로 포맷팅하겠다.
            - 112233 -> 123
            - 113322 -> 132
            - 221133 -> 213 
            - 223311 -> 231 
            - 331122 -> 312 
            - 332211 -> 321
            즉, 123 3개의 순열을 구하는 것이다.  
            -> 총 6개 -> 3! -> 3 * 2 * 1이다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int factorial = 1; // 팩토리얼 값을 저장할 변수를 초기화하고 1로 설정

        // 1부터 N까지의 모든 정수를 곱하여 factorial 변수에 저장
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        // 최종적으로 계산된 factorial 값을 출력
        System.out.println(factorial);
    }
}
