import java.util.Scanner;

public class Main {
    static int[][] adjMatrix; // 인접 행렬
    static boolean[] visited; // 방문 여부 확인 배열

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt(); // 정점의 개수
        int m = scanner.nextInt(); // 간선의 개수

        // 인접 행렬 초기화
        adjMatrix = new int[n + 1][n + 1]; // 정점 번호가 1부터 n까지이므로 크기는 n + 1

        // 간선 정보 입력 받기
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }

        // 방문 여부 배열 초기화
        visited = new boolean[n + 1];

        // 연결 요소 개수 세기
        int connectedComponents = 0;
        for (int i = 1; i <= n; i++) { // 1부터 n까지 순회
            if (!visited[i]) {
                dfs(i, n);
                connectedComponents++;
            }
        }

        // 결과 출력
        System.out.println(connectedComponents);
    }

    // 깊이 우선 탐색 (DFS) 함수 (재귀 사용)
    static void dfs(int node, int n) {
        visited[node] = true;
        for (int neighbor = 1; neighbor <= n; neighbor++) {
            if (adjMatrix[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, n);
            }
        }
    }
}
