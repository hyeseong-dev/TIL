import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        String input = "3 23 85 34 17 74 25 52 65\n"+
//                        "10 7 39 42 88 52 14 72 63\n"+
//                        "87 42 18 78 53 45 18 84 53\n"+
//                        "34 28 64 85 12 16 75 36 55\n"+
//                        "21 77 45 35 28 75 90 76 1\n"+
//                        "25 87 65 15 28 11 37 28 74\n"+
//                        "65 27 75 41 7 89 78 64 39\n"+
//                        "47 47 70 45 23 65 3 41 44\n"+
//                        "87 13 82 38 31 12 29 29 80";

//        BufferedReader br = new BufferedReader(new StringReader(input));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N과 M을 각각의 변수에 할당합니다.
        int N = 9;
        int M = 9;

        int I=0;
        int J=0;
        for (int i = 0; i < N; i++) {

        }
        int max = Integer.MIN_VALUE;

        // MatrixA N * M 사이즈에 for문을 순회하면서 각 요소에 값을 StringTokenizer객체로 가져와 형 변환 후 할당합니다.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){

                // 변수 MAX 보다 큰 경우 StringTokenizer로 불러온 값을 형변환후 할당한다.
                int num = Integer.parseInt(st.nextToken());
                if(  num > max){
                    max = num;
                    I = i;
                    J = j;
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(I+1).concat(" ").concat(String.valueOf(J+1)));
        bw.flush();
        bw.close();
        br.close();
    }
}
