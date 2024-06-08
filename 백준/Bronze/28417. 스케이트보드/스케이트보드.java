import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseNum = Integer.parseInt(br.readLine());

        int answer = Integer.MIN_VALUE;
        // 테스트 케이스만큼 루프를 돌려보자.
        for(int i = 0; i < testCaseNum; i++) {
            String[] lineString = br.readLine().split(" ");
            int[] playersScores = Arrays.stream(lineString).mapToInt(Integer::parseInt).toArray();

            // run에 대한 최고값을 찾는다.
            int runMax = Math.max(playersScores[0], playersScores[1]);

            // 슬라이싱을 통해서 `1 2 3 4 5 6 7`을  `3 4 5 6 7`까지 잘라줌
            int[] trickScores = Arrays.copyOfRange(playersScores, 2, playersScores.length);
            // 정렬을 해줌
            Arrays.sort(trickScores);

            int trickTopScore = trickScores[trickScores.length - 1];
            int trickSecondScore = trickScores[trickScores.length - 2];

            int tmpAnswer = runMax + trickTopScore + trickSecondScore;

            // player의 최고 점수를 비교한다.2
            //1 2 4 2 3 1 1
            //5 5 5 5 5 5 5
            if(tmpAnswer > answer) {
                answer = tmpAnswer;
            }

        }
        System.out.println(answer);

        br.close();
    }
}
