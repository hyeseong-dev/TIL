
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;
    static Queue<List<Integer>> Q;
    static boolean[] visited;
    static int SIZE = 100_000;
    static int location;
    static int time;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 수빈이와 동생의 위치가 같다면 수빈이가 동생을 찾을 수 있는 가장 빠른 시간은 0초(시간 소요 없음)이다.
        if(N == K) System.out.println(0);

        visited = new boolean[SIZE+1];

        // 큐 초기화
        Q = new LinkedList<>();
        ArrayList<Integer> positionNTime = new ArrayList<>();
        positionNTime.add(N);
        positionNTime.add(0);
        Q.add(positionNTime);
        visited[N] = true;

        while(!Q.isEmpty()) {
            List<Integer> current = Q.poll();
            location = current.get(0);
            time = current.get(1);

            // 세가지 이동 방식 처리
            int locMinus1 = location - 1;
            int locAdd1 = location + 1;
            int locMutiply2 = location * 2;


            for(Integer next : Arrays.asList(locMinus1, locAdd1, locMutiply2)) {

                // 유효범위 확인
                // 하나. next의 위치는 0 이상이어야 한다.
                // 둘. next의 위치는 100_000 이하여야 한다.
                // 셋. next는 방문배열(visited)에서 방문한 적이 없어야 한다.
                if(next >= 0 && next <= SIZE && !visited[next]) {
                    // 수빈이의 위치가 K(동생의 위치와 동일하다)
                    if(next == K){
                        System.out.println(time + 1);
                        return; // 종료한다.
                    }
                    Q.add(Arrays.asList(next, time+1));
                    visited[next] = true;
                }


            }
        }




    }
}
