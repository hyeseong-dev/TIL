class Solution {
    public int solution(String s) {
        int answer = 0;

        // Z가 포함되어 있지 않은 경우
        if(!s.contains("Z")){
            for(String a : s.split(" ")){
                answer += Integer.parseInt(a);
            }
            return answer;

            // Z가 포함된 경우, Z의 인덱스 이전 인덱스의 요소는 0으로 변경
        }else{
            String[] sList = s.split(" ");
            String[] sClone = sList.clone();

            for(int i = 0; i < sList.length; i++){
                if(sList[i].equals("Z")){
                    sClone[i] = "0";
                    sClone[i-1] = "0";
                }
            }
            for(String sc: sClone){
                answer += Integer.parseInt(sc);
            }
            return answer;
        }
    }
}