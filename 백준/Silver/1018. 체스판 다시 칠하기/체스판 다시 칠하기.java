import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int BOARD_LENGTH = 8;

    // 체스판 패턴 생성
    public static char[][] createSampleChessBoard(char startColor) {
        char otherColor = (startColor == 'W') ? 'B' : 'W';
        char[][] correctChessBoard = new char[8][8];

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ((x + y) % 2 == 0) {
                    correctChessBoard[x][y] = startColor;
                } else {
                    correctChessBoard[x][y] = otherColor;
                }
            }
        }
        return correctChessBoard;
    }

    // 8x8 부분 보드와 체스판 패턴 비교
    public static int compareTwoBoard(int rowSlicing, int columnSlicing, char[][] chessboard, char[][] correctSampleChessBoard) {
        int diffCount = 0;
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                int x = rowSlicing + i;
                int y = columnSlicing + j;
                if (chessboard[x][y] != correctSampleChessBoard[i][j]) {
                    diffCount++;
                }
            }
        }
        return diffCount;
    }

    // 해결 함수
    public static String solution(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] chessboard = new char[N][M];
        for (int row = 0; row < N; row++) {
            String rowStr = br.readLine();
            for (int column = 0; column < M; column++) {
                chessboard[row][column] = rowStr.charAt(column);
            }
        }

        char[][] correctSampleChessBoardW = createSampleChessBoard('W');
        char[][] correctSampleChessBoardB = createSampleChessBoard('B');

        int min = Integer.MAX_VALUE;
        for (int rowSlicingNum = 0; rowSlicingNum <= N - BOARD_LENGTH; rowSlicingNum++) {
            for (int columnSlicingNum = 0; columnSlicingNum <= M - BOARD_LENGTH; columnSlicingNum++) {
                int diffW = compareTwoBoard(rowSlicingNum, columnSlicingNum, chessboard, correctSampleChessBoardW);
                int diffB = compareTwoBoard(rowSlicingNum, columnSlicingNum, chessboard, correctSampleChessBoardB);
                min = Math.min(min, Math.min(diffW, diffB));
            }
        }
        return String.valueOf(min);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String result = solution(br, bw);
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}
