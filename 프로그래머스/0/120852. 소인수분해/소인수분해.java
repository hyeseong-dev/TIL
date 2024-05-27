import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        // 자연수 n의 소인수를 구하기 위한 반복문
        for(int i = 2; i <= n; i++){

            /**
             * 나누어 떨어지면 i는 소인수
             * 몫이 2이상인 경우도 있기 때문에 안 나눠질 때까지 나눠줌
             */
            if(n % i == 0){
                while(n % i ==0){
                    n /= i;
                }
                list.add(i); // 구한 소인수를 list에 넣어줌
            }
        }
        // 소인수 갯수와 같은 길이로 설정
        int[] answer = new int[list.size()];
        // list의 값들을 answer배열에 넣어줌.
        for(int i = 0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}