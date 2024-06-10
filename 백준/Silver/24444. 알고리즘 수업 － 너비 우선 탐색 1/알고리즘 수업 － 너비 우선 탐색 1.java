

import java.io.*;
import java.util.*;


/*
    [시간 복잡도]
    1. 그래프 초기화 및 간선 입력: O(N + M)
        - 정점 초기화: O(N)
        - 간선 입력: O(M)
    2. 인접 리스트 정렬: O(N * log N) - 각 정점의 인접 리스트를 정렬하는데 걸리는 시간
    3. BFS 탐색: O(N + M) - 각 정점을 한 번 방문하고, 모든 간선을 한 번씩 탐색

    결론: 전체 시간 복잡도: O(N log N + M)

 */
public class Main {

    static int N; // 정점의 수
    static int M; // 간선의 수
    static int R; // 시작 정점
    static ArrayList<Integer>[] graph; // 그래프 인접 리스트
    static Queue<Integer> queue;
    static boolean[] visited; // 방문 여부를 저장할 배열
    static int[] order; // 정점의 방문 순서를 저장할 배열
    static int cnt = 1; // 방문 순서 카운터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 버퍼에서 받은 첫 줄을 읽어 N, M, R에 할당합니다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 그래프, 방문 배열, 순서 배열 초기화
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1]; // 기본값 0으로 초기화

        // graph 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 무방향 그래프의 간선 끝단의 각 정점을 매핑해줍니다.
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 정점의 리스트를 오름차순으로 정렬합니다.
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 시작 정점 R에서 BFS 호출
        bfs(R);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            bw.write(order[i] + "\n");
        }
        br.close();
        bw.close();
    }

    // 깊이 우선 탐색(BFS) 메소드
    static void bfs(int start) {
        queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true; // 현재 노드를 방문으로 표시
        order[start] = cnt++; // 방문 순서 기록

        while(!queue.isEmpty()) {
            int node = queue.poll(); // 가장 마지막에 넣은 값을 꺼냄

            // 현재 정점과 인접한 정점을 확인
            for (int neighbor : graph[node]) { // 인접 정점 탐색
                if (!visited[neighbor]) { // 아직 방문하지 않은 정점인 경우
                    visited[neighbor] = true; // 방문기록 하였다고 true라고 변경함
                    queue.offer(neighbor); // 큐에 삽입
                    order[neighbor] = cnt++; // 방문 순서 기록
                }
            }
        }
    }

}
