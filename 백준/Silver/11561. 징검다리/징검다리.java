import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 입력 받기
        int T = Integer.parseInt(bf.readLine());

        // 각 테스트 케이스 처리
        for (int i = 0; i < T; i++) {
            long N = Long.parseLong(bf.readLine()); // 징검다리의 수 입력 받기
            long start = 0; // 이분 탐색의 시작점 초기화
            long last = (long) Math.sqrt((2 * N - 1)); // 이분 탐색의 끝점 초기화, 징검다리 최대 개수의 근사값
            long result = 0; // 결과값 초기화

            // 이분 탐색 시작
            while (start <= last) {
                long mid = (start + last) / 2; // 중간 값 계산
                long sum = (mid) * (mid + 1) / 2; // 1부터 mid까지의 합 계산

                // 징검다리 개수의 합이 N보다 작거나 같으면
                if (sum <= N) {
                    result = Math.max(mid, result); // 현재 mid 값이 결과값보다 크면 갱신
                    start = mid + 1; // 더 큰 범위를 탐색
                } else {
                    last = mid - 1; // 더 작은 범위를 탐색
                }
            }

            // 최종 결과 출력
            System.out.println(result);
        }
    }
}
