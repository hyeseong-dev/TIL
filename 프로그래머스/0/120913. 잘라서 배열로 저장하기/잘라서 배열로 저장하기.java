class Solution {
    public String[] solution(String my_str, int n) {
        int size = (my_str.length() + n - 1) / n ;
        String[] answer = new String[size];

        for(int i = 0; i < size; i++){
            int start = n * i;
            int end = 0;
            if(start + n >= my_str.length()){
                end = my_str.length();
            }else {
                end = start + n;
            }
            answer[i] = my_str.substring(start, end);
        }
        return answer;
    }
}