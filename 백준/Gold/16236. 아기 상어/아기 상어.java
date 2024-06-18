import java.util.*;

class Shark {
    int x, y, size, eaten;

    Shark(int x, int y, int size, int eaten) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.eaten = eaten;
    }
}

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];
        Shark shark = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0; // 아기 상어의 초기 위치를 빈 칸으로 설정
                }
            }
        }

        System.out.println(bfs(shark));
    }

    private static int bfs(Shark shark) {
        int time = 0;

        while (true) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[2] != b[2] ? a[2] - b[2] : (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1])
            );
            visited = new boolean[N][N];
            queue.add(new int[] {shark.x, shark.y, 0});
            visited[shark.x][shark.y] = true;

            boolean found = false;
            int fishX = 0, fishY = 0, fishDist = 0;

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1], dist = curr[2];

                if (map[x][y] > 0 && map[x][y] < shark.size) {
                    fishX = x;
                    fishY = y;
                    fishDist = dist;
                    found = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] <= shark.size) {
                        queue.add(new int[] {nx, ny, dist + 1});
                        visited[nx][ny] = true;
                    }
                }
            }

            if (!found) {
                return time;
            }

            shark.x = fishX;
            shark.y = fishY;
            shark.eaten++;
            map[fishX][fishY] = 0;
            time += fishDist;

            if (shark.eaten == shark.size) {
                shark.size++;
                shark.eaten = 0;
            }
        }
    }
}
