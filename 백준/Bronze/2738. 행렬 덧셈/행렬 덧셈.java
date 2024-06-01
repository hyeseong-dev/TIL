
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 첫 줄에 행렬의 크기를 문자열에서 정수형 배열로 변경해줍니다. N M
        int[] matrixSize = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

        // N과 M을 각각의 변수에 할당합니다.
        int N = matrixSize[0];
        int M = matrixSize[1];

        // 매트릭스 2개의 크기를 초기화 합니다.
        int[][] matrixA = new int[N][M];
        int[][] matrixB = new int[N][M];

        // MatrixA N * M 사이즈에 for문을 순회하면서 각 요소에 값을 StringTokenizer객체로 가져와 형 변환 후 할당합니다.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방법은 위 코드와 동일합니다.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // MatrixA와 MatrixB의 동일한 행과 열의 좌표를 더하여 BufferedWriter객체에 저장해줍니다.
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                String element = String.valueOf(matrixA[i][j] + matrixB[i][j]);
                bw.write(element.concat(" "));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
