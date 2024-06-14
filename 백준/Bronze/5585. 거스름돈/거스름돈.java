
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 물건의 가격을 입력받음
        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price; // 1000엔 지폐에서 가격을 뺀 나머지가 거스름돈

        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;

        // 가장 큰 동전부터 시작하여 거스름돈을 줄임
        for (int coin : coins) {
            if (change >= coin) {
                count += change / coin; // 해당 동전을 사용할 수 있는 최대 개수를 더함
                change %= coin; // 나머지 거스름돈을 계산
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
