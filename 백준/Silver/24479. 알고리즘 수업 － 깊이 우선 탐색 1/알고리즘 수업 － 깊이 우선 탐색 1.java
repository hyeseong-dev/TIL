import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N; // 정점의 수
    static int M; // 간선의 수
    static int R; // 시작 정점
    static StringTokenizer st;
    static ArrayList<Integer>[]  graph;
    static int[] order;
    static boolean[] visited;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        // 버퍼에서 받은 첫 줄을 읽어 N, M, R에 할당합니다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        order = new int[N+1]; // 기본값 0으로 초기화
        // graph 초기화
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        // 무방향 그래프의 간선 끝단의 각 정점을 매핑해준다.
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 각 정점의 리스트를 오름차순으로 정렬
        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        // DFS호출
        dfs(R);

        // 결과 출력
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(order[i] + "\n");
        }
        br.close();
        bw.close();

    }

    static void dfs(int node){
        visited[node] = true;
        order[node] = cnt++;
        for(int neighbor : graph[node]){
            if(!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }
}
