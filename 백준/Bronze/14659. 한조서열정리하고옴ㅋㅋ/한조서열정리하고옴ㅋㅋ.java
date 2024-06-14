import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 봉우리의 수 N을 입력받음
        int numberOfPeaks = Integer.parseInt(br.readLine());
        // 두 번째 줄에서 각 봉우리의 높이를 입력받아 배열에 저장
        int[] peakHeights = new int[numberOfPeaks];

        // 입력받은 높이를 공백을 기준으로 분리하여 배열에 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < numberOfPeaks; i++) {
            peakHeights[i] = Integer.parseInt(input[i]);
        }

        int maxEnemiesDefeated = 0;  // 처치할 수 있는 최대 적의 수를 저장

        // 각 봉우리에 대해 오른쪽으로 이동하며 처치할 수 있는 적의 수를 계산
        for (int i = 0; i < numberOfPeaks; i++) {
            int enemiesDefeated = 0;  // 현재 봉우리에서 처치할 수 있는 적의 수를 저장
            for (int j = i + 1; j < numberOfPeaks; j++) {
                // 현재 봉우리보다 낮은 봉우리인 경우 적을 처치하고 카운트 증가
                if (peakHeights[j] < peakHeights[i]) {
                    enemiesDefeated++;
                } else {
                    // 현재 봉우리보다 높은 봉우리를 만나면 더 이상 진행하지 않음
                    break;
                }
            }
            // 현재 봉우리에서 처치할 수 있는 최대 적의 수를 갱신
            maxEnemiesDefeated = Math.max(maxEnemiesDefeated, enemiesDefeated);
        }

        // 결과 출력: 처치할 수 있는 최대 적의 수
        System.out.println(maxEnemiesDefeated);
    }
}
