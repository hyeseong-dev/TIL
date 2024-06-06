

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        /**
         * [Comparator의 compare 메서드에서 반환되는 값에 따라 원소들의 정렬이 결정]
         *
         * 1. 반환값이 음수일 경우: 첫 번째 매개변수(o1)가 두 번째 매개변수(o2)보다 작다는 의미입니다.
         *                     따라서 o1은 우선순위가 높아집니다.
         *
         * 2. 반환값이 양수일 경우: 첫 번째 매개변수(o1)가 두 번째 매개변수(o2)보다 크다는 의미입니다.
         *                     따라서 o1은 우선순위가 낮아집니다.
         * 3. 반환값이 0일 경우: 두 매개변수(o1, o2)가 서로 같다는 의미입니다.
         *                   이 경우에는 순서가 변경되지 않습니다.
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }else{
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        for(int i = 0; i < N; i++) {
            int x = s.nextInt();
            if(x == 0){
                int answer = pq.isEmpty() ? 0 : pq.poll();
                System.out.println(answer);
            }else{
                pq.offer(x);
            }
        }
    }
}
