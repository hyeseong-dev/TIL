import java.io.*;
import java.util.*;

public class Main {
    static void solution(int N, int K, BufferedWriter bw) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 요세푸스 순열을 담을 리스트
        List<Integer> josephus = new ArrayList<>();

        // 리스트에 1부터 N까지의 수를 담는다.
        for (int i = 1; i <= N; i++) {
            josephus.add(i);
        }

        int idx = 0;
        while (josephus.size() > 0) {
            // 인덱스를 K만큼 증가시킨다.
            idx = (idx + K - 1) % josephus.size();
            // 해당하는 요소를 출력 문자열에 추가한다.
            sb.append(josephus.remove(idx));
            // 마지막 요소가 아니라면 쉼표를 추가한다.
            if (josephus.size() > 0) {
                sb.append(", ");
            }
        }

        sb.append(">");
        bw.write(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        solution(N, K, bw);
        bw.flush();
        bw.close();
        br.close();
    }
}
