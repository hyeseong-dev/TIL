class Solution {
    public String solution(int age) {
        String answer = "";
        String numStr = String.valueOf(age);

        for(int i = 0; i < numStr.length(); i++){
            int i1 = Integer.valueOf(String.valueOf(numStr.charAt(i))) + 97;
            answer += (char) i1;
        }
        return answer;
    }
}