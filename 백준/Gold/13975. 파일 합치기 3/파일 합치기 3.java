
import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T; // 테스트케이스가 실행 될 횟수
    static int CHAPTER; // 소설을 구성하는 장의 수를 나타내는 양의 정수 K (3 ≤ K ≤ 1,000,000)
    static PriorityQueue<Long> pq; // 1장부터 K장까지 수록한 파일의 크기를 나타내는 양의 정수 K개, 파일의 크기는 10,000을 초과하지 않는다.
    static long totalCost;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int K = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Long> pq = new PriorityQueue<>();
            for(int i = 0; i < K; i++) pq.offer(Long.parseLong(st.nextToken()));

            long answer = 0;
            long sum = 0;

            while(true) {
                long smallest1 = pq.poll();
                long smallest2 = pq.poll();
                sum = smallest1 + smallest2;

                answer += sum;

                if(pq.isEmpty()) break;
                pq.offer(sum);

            }
            bw.append(String.valueOf(answer).concat("\n"));
        }
        bw.flush();
        bw.close();
        br.readLine();


    }

}
