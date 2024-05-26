class Solution {
    public int solution(int order) {
        int answer = 0;
        String[] strs = String.valueOf(order).split("");
        for(String str : strs){
            if(str.equals("3") || str.equals("6") || str.equals("9")){
                answer++;
            }
        }
        return answer;
    }
}