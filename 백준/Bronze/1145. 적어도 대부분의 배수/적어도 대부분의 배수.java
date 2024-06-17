
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 버퍼로부터 첫줄을 읽어 Arrays.stream을 이용하여 정수 배열로 변환
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 초기 최소값을 최대값으로 설정
        int answer = Integer.MAX_VALUE;

        // 세 수의 모든 조합에 대해 최소 공배수를 계산하고 최소값을 업데이트
        for (int i = 0; i < intArr.length - 2; i++) {
            for (int j = i + 1; j < intArr.length - 1; j++) {
                for (int k = j + 1; k < intArr.length; k++) {
                    int lcmValue = lcm(intArr[i], intArr[j], intArr[k]);
                    if (lcmValue < answer) {
                        answer = lcmValue;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    // 두 수의 최대공약수를 구하는 메소드
    static int gcd(int numA, int numB) {
        while (numB != 0) {
            int temp = numB;
            numB = numA % numB;
            numA = temp;
        }
        return numA;
    }

    // 두 수의 최소공배수를 구하는 메소드
    static int lcm(int numA, int numB) {
        return (numA * numB) / gcd(numA, numB);
    }

    // 세 수의 최소공배수를 구하는 메소드
    static int lcm(int numA, int numB, int numC) {
        return lcm(lcm(numA, numB), numC);
    }
}
