import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            br.readLine();
            int[] numArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = 0;
            for(int num: numArr) {
                if(isPrime(num) && num != 1){
                    result += 1;
                }

            }
            bw.write(String.valueOf(result));
        } catch (IOException e) {e.printStackTrace();}}

    static boolean isPrime(int number){
        if (number <= 1) {
            return false;
        }
        // 2 또는 3이 주어진 숫자와 같으면 소수이므로 true를 반환합니다.
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
}