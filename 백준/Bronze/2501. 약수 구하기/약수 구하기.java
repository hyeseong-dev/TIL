import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력 처리
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            // 약수를 저장할 리스트
            List<Integer> divisors = new ArrayList<>();

            // 약수 구하기
            for (int i = 1; i <= N; i++) {
                if (N % i == 0) {
                    divisors.add(i);
                }
            }

            // 약수 정렬
            Collections.sort(divisors);

            // K번째 약수 출력
            if (K <= 0 || K > divisors.size()) {
                System.out.println(0);
            } else {
                System.out.println(divisors.get(K - 1));
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력 형식입니다.");
        }
    }
}
