
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 우유 가게의 수 N 입력

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] milkStores = new int[N]; // 버퍼에서 우유 가게 정보 입력 받습니다.
        
        for (int i = 0; i < N; i++) {
            milkStores[i] = Integer.parseInt(st.nextToken());
        }

        // 우유의 종류 (0: 딸기, 1: 초코, 2: 바나나)
/*
        currentMilk를 0으로 초기화한 이유
        문제 설명 참고 시, `딸기 마시고 -> 초코 마시고 -> 바나나 마시고 -> 딸기 마시는` 규칙이 있다고 명시함.
*/
        int currentMilk = 0;
        int count = 0;

        // 우유 가게들을 순회하며 영학이가 마실 수 있는 우유의 최대 개수를 계산
        for (int i = 0; i < N; i++) {
            if (milkStores[i] == currentMilk) {
                count++;
                currentMilk = (currentMilk + 1) % 3;
            }
        }

        // 결과 출력
        System.out.println(count);

        br.close();
    }
}

