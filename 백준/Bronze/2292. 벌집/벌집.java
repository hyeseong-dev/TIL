import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사용자로부터 방 번호 N을 입력받습니다.
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        // 레벨을 계산하기 위한 변수 초기화
        int nums_pileup = 1;  // 벌집의 개수, 1개부터 시작
        int cnt = 1;  // 반복 횟수 및 현재 레벨
        
        // 레벨 계산 루프
        while (N > nums_pileup) {
            nums_pileup += 6 * cnt;  // 벌집이 6의 배수로 증가
            cnt++;  // 레벨을 증가시키기
        }
        
        // 결과 출력
        System.out.println(cnt);
    }
}
