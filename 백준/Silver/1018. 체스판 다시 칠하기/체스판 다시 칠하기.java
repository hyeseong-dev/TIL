import java.io.*;
import java.util.StringTokenizer;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int BOARD_LENGTH = 8;
    static char W = 'W';
    static char B = 'B';

    // 체스판 패턴 생성
    public static char[][] createSampleChessBoard(char startColor) {

        // otherColor의 값은 <---> startColor와 반대된느 값을 할당하기 위함
        // 삼항 연산자를 이용함.
        char otherColor = (startColor == W) ? B : W;

        char[][] correctChessBoard = new char[8][8];

        for (int x = 0; x < BOARD_LENGTH; x++) {
            for (int y = 0; y < BOARD_LENGTH; y++) {
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
    // 두 수의 최소값 찾기
    public static int findMin(int min, int other){
        if(other<min){
            min = other;
        }
        return min;
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

        // 만약 단순히 buffer입력의 왼쪽 최상단 char를 startColor('W' or 'B')로 선택하여 한개의 정답 샘플 체스보드로 만들 경우
        // 틀리게 된다. 그 예로 예제입력4로 하게 되면 문제가 된다.
        char[][] correctSampleChessBoardW = createSampleChessBoard(W); // 왼쪽 상단을 'W'로 시작하여 채운 체스판 샘플
        char[][] correctSampleChessBoardB = createSampleChessBoard(B); // 왼쪽 상단을 'B'로 시작하여 채운 체스판 샘플

        // 종료 조건이 N- BOARD_LENGTH인 것은 sling을 몇번만 해야 기준을 잡아주는 것이다.
        // 만약 입력 첫 줄이 `8 8`이면 1번, 0<= 8-8(BOARD_LENGTH) 를 돌게 된다
        // 만약 입력 첫 줄이 `9 9`이면 2번, 0<= 9-8(BOARD_LENGTH) 를 돌게 된다 -> 행이 몇번 돌아야 할지 판단
        // `열`이 몇번 돌아야 할지 판단하는 것도 위 설명과 비슷하다.
        // 모든 경우의 수를 이용하여 8 * 8로 자른 체스 보드에서 칠한 횟수가 가장 작은 값을 정수 리스트에 담는다.
        int min = Integer.MAX_VALUE;
        for (int rowSlicingNum = 0; rowSlicingNum <= N - BOARD_LENGTH; rowSlicingNum++) {
            for (int columnSlicingNum = 0; columnSlicingNum <= M - BOARD_LENGTH; columnSlicingNum++) {
                int wBoardRecoloredCount = compareTwoBoard(rowSlicingNum, columnSlicingNum, chessboard, correctSampleChessBoardW);
                int bBoardRecoloredCount = compareTwoBoard(rowSlicingNum, columnSlicingNum, chessboard, correctSampleChessBoardB);

                min = findMin(min, findMin(wBoardRecoloredCount, bBoardRecoloredCount));
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
