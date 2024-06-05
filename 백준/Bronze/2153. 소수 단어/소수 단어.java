// 메모리:	 KB
// 속도: 	 ms

import java.io.*;
import java.util.Stack;

public class Main {

    static int UPPERCASE_NUM  = 38;
    static int LOWERCASE_NUM = 96;

    static boolean isPrime(int number){
        // 1은 소수가 아님(하지만 백준 문제 설명에서 1은 소수로 하자고 조건을 붙임)
        if (number <= 1) {
            return true;
        }
        // 2와 3은 소수
        if (number == 2 || number == 3) {
            return true;
        }
        // 짝수와 3의 배수는 소수가 아님
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        // n의 제곱근까지 검사
        int sqrt = (int) Math.sqrt(number);
        // 소수 판별 알고리즘: 6k ± 1의 형태로 나누어 떨어지지 않으면 소수
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    static void solution(BufferedReader br, BufferedWriter bw) throws IOException{

        String string = br.readLine();

        int num = 0;
        for (int i = 0; i < string.length(); i++){
            char chr = string.charAt(i);

            // 대문자 문자
            if(Character.isUpperCase(chr)){
                num += chr - UPPERCASE_NUM;

            // 소문자 문자
            }else{
                num += chr - LOWERCASE_NUM;
            }
        }

        String answer = isPrime(num) ? "It is a prime word.": "It is not a prime word.";
        bw.write(answer);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        solution(br, bw);
        bw.flush();
        bw.close();
        br.close();
    }
}
