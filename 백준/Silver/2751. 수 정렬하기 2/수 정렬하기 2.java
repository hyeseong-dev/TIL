import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력 처리
        int N = Integer.parseInt(br.readLine());
        // 최대 절댓값이 1,000,000이므로 계수 배열의 크기는 2,000,001
        int MAX_VAL = 1000000;
        int OFFSET = 1000000;  // 계수 배열을 0 기준으로 맞추기 위한 오프셋
        
        // 계수 배열 생성
        boolean[] count = new boolean[2 * MAX_VAL + 1];
        
        // 숫자 읽고 계수 배열 업데이트
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num + OFFSET] = true;  // 해당 숫자가 존재한다고 표시
        }
        
        // 정렬된 결과 출력
        for (int i = 0; i < count.length; i++) {
            if (count[i]) {
                bw.write((i - OFFSET) + "\n");
            }
        }
        
        // 자원 해제
        br.close();
        bw.close();
    }
}
