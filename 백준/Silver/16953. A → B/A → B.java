
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 큐를 사용하여 BFS 탐색을 위해 현재 숫자와 연산 횟수를 저장
        Queue<long[]> queue = new LinkedList<>();
        // 초기 상태로 A와 연산 횟수 1을 큐에 추가
        queue.add(new long[]{A, 1}); // 현재 숫자, 연산 횟수

        // 큐가 비어있지 않은 동안 반복
        while(!queue.isEmpty()){
            // 큐의 맨 앞 요소를 꺼내어 현재 상태를 얻음
            long[] current = queue.poll();
            long num = current[0];
            long count = current[1];

            // 현재 숫자가 B와 같다면 연산 횟수를 출력하고 프로그램 종료
            if(num == B) {
                System.out.println(count);
                return;
            }

            // 주의!!
            // 아래 if조건 절에서 공통된 `long[] tempArr = new long[2];`를 if 외부에서 선언하고 재활용시 참조 문제를 발생시킨다.

            // 연산 1: 2를 곱한다.
            boolean condition1 = num * 2 <= B;
            if(condition1) {
                // 새로운 상태를 저장할 배열 생성
                long[] tempArr = new long[2];
                tempArr[0] = num*2; // 현재 숫자에 2를 곱한 값을 저장
                tempArr[1] = count+1; // 연산 횟수를 1 증가
                queue.add(tempArr); // 새로운 상태를 큐에 추가
            }

            // 연산 2: 1을 수의 가장 오른쪽에 추가한다.
            boolean condition2 = num * 10 + 1 <= B;
            if(condition2){
                // 새로운 상태를 저장할 배열 생성
                long[] tempArr = new long[2];
                tempArr[0] = num * 10 + 1; // 현재 숫자의 가장 오른쪽에 1을 추가한 값을 저장
                tempArr[1] = count + 1; // 연산 횟수를 1 증가
                queue.add(tempArr); // 새로운 상태를 큐에 추가
            }
        }
        // 큐가 비었는데도 B를 만들 수 없다면 -1을 출력
        System.out.println(-1);
        br.close();
    }
}
