import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }
        
        System.out.println(longestDecreasingSubsequence(A));
        
        br.close();
    }
    
    public static int longestDecreasingSubsequence(int[] A) {
        int N = A.length;
        int[] lds = new int[N];
        
        // 모든 원소의 lds 값을 1로 초기화
        for (int i = 0; i < N; i++) {
            lds[i] = 1;
        }
        
        // 동적 계획법 적용
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        
        // lds 배열에서 가장 큰 값을 찾음
        int maxLDS = 0;
        for (int i = 0; i < N; i++) {
            maxLDS = Math.max(maxLDS, lds[i]);
        }
        
        return maxLDS;
    }
}
