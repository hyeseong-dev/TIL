import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 전체 사람의 수 입력
        int n = scanner.nextInt();
        int[][] relations = new int[n + 1][n + 1];

        // 촌수를 계산해야 하는 두 사람의 번호 입력
        int person1 = scanner.nextInt();
        int person2 = scanner.nextInt();

        // 부모 자식간의 관계 개수 입력
        int m = scanner.nextInt();

        // 부모 자식간의 관계 입력
        for (int i = 0; i < m; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            relations[parent][child] = 1;
            relations[child][parent] = 1; // 부모-자식 양방향 관계를 저장
        }

        // BFS를 사용하여 최소 촌수 계산
        int result = bfs(person1, person2, relations);
        System.out.println(result);

        scanner.close();
    }

    private static int bfs(int start, int end, int[][] relations) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[relations.length];
        int[] chonsu = new int[relations.length]; // 각 사람의 촌수를 저장하는 배열

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목표 노드에 도달한 경우 촌수를 반환
            if (current == end) {
                return chonsu[current];
            }

            // 현재 노드와 관계가 있는 사람들을 방문하고 촌수를 증가시킴
            for (int i = 1; i < relations.length; i++) {
                if (relations[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    chonsu[i] = chonsu[current] + 1;
                    queue.offer(i);
                }
            }
        }

        // 두 사람의 친척 관계가 없을 경우
        return -1;
    }
}
