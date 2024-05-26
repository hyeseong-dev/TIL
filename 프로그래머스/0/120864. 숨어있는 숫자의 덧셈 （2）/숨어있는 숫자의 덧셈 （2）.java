class Solution {
    public static int solution(String my_string) {
        int answer = 0;

        int i = 0;
        while (i < my_string.length()) {
            StringBuilder sb = new StringBuilder();
            int idx = i;

            while ( idx < my_string.length() && Character.isDigit(my_string.charAt(idx)) ){
                sb.append(my_string.charAt(idx++));

            }
            String checkDigit = sb.toString();
            if(isInteger(checkDigit)){
                answer += Integer.parseInt(checkDigit);
                if(checkDigit.length() != 1){
                    i += checkDigit.length() - 1;
                }
            }

            i++;
        }

        return answer;
    }

    private static boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}