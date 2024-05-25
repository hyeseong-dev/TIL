import java.util.ArrayList;
import java.util.List;

class Solution { 
    public List<Integer> solution(int[] arr, int[] delete_list) {
        
            List<Integer> answer = new ArrayList<>();

            for(int i = 0; i < arr.length; i++) {
                answer.add(arr[i]);
            }

            for(int num: arr){
                for(int del_num : delete_list){
                    if(del_num == num){
                        answer.remove(Integer.valueOf(num));
                    }
                }
            }


            return answer;
    }
}