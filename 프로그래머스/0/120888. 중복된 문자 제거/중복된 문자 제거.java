class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(String ch : my_string.split("")){
            if(!answer.contains(ch)) answer += ch;
        }
        return answer;
    }
}