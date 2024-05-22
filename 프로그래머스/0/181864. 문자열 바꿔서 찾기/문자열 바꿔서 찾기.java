class Solution {
    public int solution(String myString, String pat) {
        String sb = "";
        for(int i = 0; i < myString.length(); i++){
            if (myString.charAt(i) == 'A'){
                sb += "B";
            }else{
                sb += "A";
            }

        }
        return sb.toString().contains(pat) ? 1 : 0;
    }
}