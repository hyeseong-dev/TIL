

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위해 BufferedReader를 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 번째 줄에서 N과 K를 입력받음
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류 수
        int K = Integer.parseInt(st.nextToken()); // 목표 금액

        // 동전의 종류를 저장할 배열 생성
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            // 각 동전의 가치를 입력받음
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0; // 필요한 동전의 총 개수

        // 가장 큰 동전부터 시작하여 금액 K를 맞추기 위한 반복문
        for (int i = N - 1; i >= 0; i--) {
            // 현재 동전이 목표 금액 K보다 크다면 넘어감
            if (coins[i] > K) continue;

            // 현재 동전으로 만들 수 있는 최대 개수를 더함
            count += (K / coins[i]);

            // 남은 금액을 계산
            K = K % coins[i];
        }

        // 결과 출력: 필요한 동전의 총 개수
        System.out.println(count);
        br.close();
    }
}
