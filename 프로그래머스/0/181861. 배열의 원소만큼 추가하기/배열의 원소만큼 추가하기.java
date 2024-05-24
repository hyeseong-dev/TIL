import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answers = new ArrayList<>();
        for(int num: arr){
            for(int i = 0 ; i < num ; i++){
                answers.add(num);
            }
        }

        return answers;
    }
}