import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {

    public static int solution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        

        // Q. 왜? grid 이차원 배열의 row크기를 N으로 할당하였는가?
        //    그리고 gird 이차원 배열을[N][]으로 했는가?
        // N과 M중 `작은 값`을 선택하여 정사각형의 너비와 높이로 설정한다.
        int squreLen = Math.min(N, M);

        // 네개의 꼭지점을 가진 x,y 좌표 정사각형이 될 수 없으므로 1을 반환함.
        if (squreLen == 1) return 1;

        // matrix 초기화 한다.
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int maxSize = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 시작점 (i, j)에서 최대 가능한 정사각형 크기 구하기
                for (int k = 1; i + k < N && j + k < M; k++) {
                    if (grid[i][j] == grid[i + k][j]
                            && grid[i][j] == grid[i][j + k]
                            && grid[i][j] == grid[i + k][j + k]) {
                        int squareSize = (k + 1) * (k + 1);
                        if (squareSize > maxSize) {
                            maxSize = squareSize;
                        }
                    }
                }
            }
        }


        return maxSize;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = solution(br);
        System.out.println(answer);
        br.close();
    }
}

