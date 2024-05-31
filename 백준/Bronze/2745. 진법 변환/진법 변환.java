import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        // B진법 수 N을 10진법으로 변환
        int decimalValue = Integer.parseInt(N, B);

        // 결과 출력
        System.out.println(decimalValue);
    }
}
