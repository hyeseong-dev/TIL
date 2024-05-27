class Solution {
    public int solution(int i, int j, int k) {
            int answer = 0;
            String strK = String.valueOf(k);

            for(; i <= j; i++){
                String strI = String.valueOf(i);
                if ( strI.equals(strK) || strI.contains(strK) ) {
                    if(strI.length() > 1){
                        for(char ch : strI.toCharArray()){
                            if (Integer.parseInt(ch+"") == k){
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