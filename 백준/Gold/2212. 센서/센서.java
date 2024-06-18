import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] sensors = new int[N];
        
        for (int i = 0; i < N; i++) {
            sensors[i] = scanner.nextInt();
        }

        // 센서 좌표 정렬
        Arrays.sort(sensors);

        // 인접한 센서 사이의 거리 계산
        int[] distances = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리를 오름차순으로 정렬
        Arrays.sort(distances);

        // K개의 집중국을 설치하는 경우 K-1개의 가장 큰 간격을 제거
        int minDistanceSum = 0;
        for (int i = 0; i < N - K; i++) {
            minDistanceSum += distances[i];
        }

        System.out.println(minDistanceSum);
    }
}
