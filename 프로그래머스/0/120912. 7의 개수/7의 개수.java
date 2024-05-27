class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String str7 = String.valueOf("7");

        for (int i = 0; i < array.length; i++) {
            String strValue = String.valueOf(array[i]);
            if(strValue.equals(str7) || strValue.contains(str7)){
                if(strValue.length() >1){
                    for(char c : strValue.toCharArray()){
                        if((c + "").equals(str7) ){
                            answer++;
                        }
                    }
                }else{
                    answer++;
                }
            }
        }
        return answer;
    }
}