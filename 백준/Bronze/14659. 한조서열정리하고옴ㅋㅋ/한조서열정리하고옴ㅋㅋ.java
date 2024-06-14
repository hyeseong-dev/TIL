import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());  // 봉우리의 수
        int[] heights = new int[N];  // 봉우리의 높이 배열
        
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(input[i]);
        }
        
        int maxEnemies = 0;  // 처치할 수 있는 최대 적의 수

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                if (heights[j] < heights[i]) {
                    count++;
                } else {
                    break;
                }
            }
            maxEnemies = Math.max(maxEnemies, count);
        }
        
        System.out.println(maxEnemies);
    }
}
