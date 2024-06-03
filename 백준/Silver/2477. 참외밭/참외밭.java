import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 참외의 수 입력 받기
        int 참외의_수 = Integer.parseInt(st.nextToken());
        
        int 가로_최대길이 = 0, 세로_최대길이 = 0; // 각 가로, 세로의 최대 길이 저장
        int 가로_최대길이_인덱스 = -1, 세로_최대길이_인덱스 = -1; // 가로, 세로의 최대 길이의 인덱스 저장
        int[] 방향 = new int[6]; // 순서대로 방향 저장
        int[] 길이 = new int[6]; // 변의 길이 저장
        
        // 6개의 변에 대한 방향과 길이 입력 받기
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            방향[i] = Integer.parseInt(st.nextToken());
            길이[i] = Integer.parseInt(st.nextToken());
            
            // 가로 방향이면
            if (방향[i] == 1 || 방향[i] == 2) {
                // 가로에 해당하는 변수들의 최대값, 인덱스 저장
                if (가로_최대길이 < 길이[i]) {
                    가로_최대길이 = 길이[i];
                    가로_최대길이_인덱스 = i;
                }
            } else { // 세로 방향이면
                // 세로에 해당하는 변수들의 최대값, 인덱스 저장
                if (세로_최대길이 < 길이[i]) {
                    세로_최대길이 = 길이[i];
                    세로_최대길이_인덱스 = i;
                }
            }
        }
        
        // 전체 사각형의 넓이와 안에 있는 사각형의 넓이 계산
        int 전체_사각형_넓이 = 가로_최대길이 * 세로_최대길이;
        int 안에_있는_사각형_넓이 = 길이[(가로_최대길이_인덱스 + 3) % 6] * 길이[(세로_최대길이_인덱스 + 3) % 6];
        
        // 참외밭의 넓이 계산 후 출력
        System.out.println((전체_사각형_넓이 - 안에_있는_사각형_넓이) * 참외의_수);
    }
}
