

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E, start, end;
    static ArrayList<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        graph = new ArrayList[V + 1];

        for(int i = 1; i <= V; i++)
            graph[i] = new ArrayList<>();

        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        solution();
    }

    static void solution(){
        Arrays.fill(dist, -1);
        BFS(start);
        System.out.println(dist[end]);
    }

    static void BFS(int x){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        dist[x] = 0;
        while(!Q.isEmpty()){
            x = Q.poll();

            for(int y : graph[x]){
                if(dist[y] != -1) continue; // 이미 방문 하였다.
                Q.add(y);
                dist[y] = dist[x] + 1; // 이동 횟수 증가
            }
        }
    }
}
