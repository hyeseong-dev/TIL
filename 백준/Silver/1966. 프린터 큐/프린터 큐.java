import java.io.*;
import java.util.*;

public class Main {

    /*
        [시간 복잡도]
            - 큐 : 각 문서에 대해 큐에서 제거하고 다시 삽입하는 작업은 최대 N번 일어납니다. 따라서 큐 조작의 시간 복잡도는 O(N).
            - 우선순위 큐 : 우선순위 큐에서 삽입 및 제거 작업의 시간 복잡도는 O(log N).
                        최대 N번의 삽입 및 제거 작업이 일어나므로, 우선순위 큐 조작의 시간 복잡도는 O(N log N).

            결론 : 따라서, 전체 시간 복잡도는 O(N log N)입니다. 이는 기존의 O(N^2) 시간 복잡도보다 효율적입니다.
     */
    static String solution(BufferedReader br) throws IOException {
        int cycle = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        while (cycle-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numDoc = Integer.parseInt(st.nextToken());
            int curDocIdx = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numDoc; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, priority});
                priorityQueue.offer(priority);
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int idx = current[0];
                int priority = current[1];

                if (priority == priorityQueue.peek()) {
                    printOrder++;
                    priorityQueue.poll();
                    if (idx == curDocIdx) {
                        result.append(printOrder).append("\n");
                        break;
                    }
                } else {
                    queue.offer(current);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = solution(br);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
