import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();

        int i = 1;

        while(i <= n ){
            if(n % i == 0 ) {
                answer.add(i);
            }
            i++;
        }

        return answer;
    }
}