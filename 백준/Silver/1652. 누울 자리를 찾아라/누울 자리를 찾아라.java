import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N; // 입력 첫째줄에 주어진 Digit
        int widthCount = 0;  // 출력 시, 가로로 누울 수 있는 숫자
        int heightCount = 0; // 출력 시, 세로로 ""   ""    ""

        N = Integer.parseInt(br.readLine());

        char[][] matrix = new char[N][N]; // 가로, 세로 N크기만큼의 정사각형 초기화

        // 이차원 char 배열의 내부 값을 `.` 버퍼에서 가져온 '.' 또는 'X' 중에 하나로 할당함.
        for (int height = 0; height < N; height++) {
            String rowStr = br.readLine();
            for (int width = 0; width < N; width++) {
                matrix[height][width] = rowStr.charAt(width);
            }
        }

        // 가로 방향 확인
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        widthCount++;
                    }
                    count = 0;
                }
            }
            if (count >= 2) {
                widthCount++;
            }
        }

        // 세로 방향 확인
        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (matrix[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        heightCount++;
                    }
                    count = 0;
                }
            }
            if (count >= 2) {
                heightCount++;
            }
        }

        bw.write(widthCount + " " + heightCount);
        bw.flush();
        bw.close();
        br.close();
    }

    static String edgeCase4() {
        return "5\n" +
                "X..X.\n" +
                "..X..\n" +
                ".X...\n" +
                "...X.\n" +
                "X..X.";
    }

    // Other test cases...

}
