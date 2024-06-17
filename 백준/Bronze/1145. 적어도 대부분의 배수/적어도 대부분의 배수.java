
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> memo = new HashMap<>(); // 팩토리얼 사용시 메모이제이션 사용을 위함.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader(input1()));

        // 버퍼로부터 첫줄을 읽어 Arrays.stream을 이용하여 정수 배열로 변환
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 조합의 공식을 이용함 nCr
        int N = 5; // 조합을 구하기 위한 배열의 크기 n
        int R = 3; // 조합의 r에 해당

        // 최소 공배수 담기 위한 배열의 크기 초기화
        // 공식을 이용하여 배열의 크기 초기화를 진행한다.  N! / (N-R)! * R!
        int nFacResult = factorial(N);
        int nMinusRFacResult = factorial(N-R);
        int rFacResult = factorial(R);

        // 최소공배수 크기
        int lcmSize = nFacResult / (nMinusRFacResult * rFacResult);

        int[][] lcmArr = new int[lcmSize][R];

        int idx = 0;

        for(int i = 0; i < intArr.length-1; i++){
            for(int j = i+1; j < intArr.length; j++){
                for(int k = j+1; k < intArr.length; k++){
                    lcmArr[idx++] = new int[]{intArr[i], intArr[j], intArr[k]};
                }
            }
        }

        int[] answerArr = new int[lcmSize];
        for(int i = 0; i < lcmArr.length; i++){
            answerArr[i] = lcm(lcmArr[i][0], lcmArr[i][1], lcmArr[i][2]);
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < answerArr.length; i++)
            if(answerArr[i] < answer) answer = answerArr[i];

        System.out.println(answer);
    }

    // --------------------------------------------------------
    // 두 수의 최대공약수를 구하는 메소드
    static int gcd(int numA, int numB){
        while(numB != 0){
            int temp = numB;
            numB = numA % numB;
            numA = temp;
        }
        return numA;
    }

    // 두 수의 최소공배수를 구하는 메소드
    static int lcm(int numA, int numB){
        return (numA * numB) / gcd(numA, numB);
    }

    static int lcm(int numA, int numB, int numC){
        int lcmAB = lcm(numA, numB); // numA, numB의 최소 공배수를 구합니다.
        return lcm(lcmAB, numC); // lcmAB, numC의 최소공배수를 구합니다.
    }

    // --------------------------------------------------------

    // DP의 bottom-up방식(aka. Tabulation)으로 factorial을 사용하여 일반 팩토리얼 시간복잡도인, O(2^N)보다 효율적임.
    static int factorial(int n) {
        if (n == 0) {
            return 1;  // Base case: 0! = 1
        }

        int[] table = new int[n + 1];  // 팩토리얼 값을 저장하기 위한 배열
        table[0] = 1;  // 기저점(base case)을 초기화

        for (int i = 1; i <= n; i++) {
            table[i] = i * table[i - 1];  // table을 계속 순회하여 채워줍니다.
        }

        return table[n];  // n 팩토리얼의 값을 반환합니다.
    }
// --------------------------------------------------------
    static String input1(){
        return "30 42 70 35 90";
    }
}
