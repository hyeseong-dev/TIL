class Solution {
    public static int[] solution(int[] arr, String direction) {
        int[] answer = new int[arr.length];

        if(direction.equals("right")){
            for(int i = 1; i < arr.length; i++){
                 answer[i] = arr[i-1];
            }
            answer[0] = arr[arr.length-1];
        }else{
            for(int i = 1; i < arr.length; i++){
                answer[i-1] = arr[i];
            }
            answer[arr.length - 1] = arr[0];
        }
        return answer;
    }
}