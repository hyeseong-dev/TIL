class Solution {
    public int solution(int num, int k) {
        int answer = -1;

        String tmpStr = String.valueOf(num);
        String[] tmpStrList = tmpStr.split("");

        for(int i=0; i<tmpStrList.length; i++){
            if(Integer.valueOf(tmpStrList[i])== k){
                answer = i + 1;
                break;
            };

        }

        return answer;
    }
}