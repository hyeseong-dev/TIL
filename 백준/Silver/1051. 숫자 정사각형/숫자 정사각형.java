import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        char[][] grid = new char[N][];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int maxSize = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 시작점 (i, j)에서 최대 가능한 정사각형 크기 구하기
                for (int k = 1; i + k < N && j + k < M; k++) {
                    if (grid[i][j] == grid[i + k][j] && grid[i][j] == grid[i][j + k] && grid[i][j] == grid[i + k][j + k]) {
                        int squareSize = (k + 1) * (k + 1);
                        if (squareSize > maxSize) {
                            maxSize = squareSize;
                        }
                    }
                }
            }
        }

        System.out.println(maxSize);
    }
}

