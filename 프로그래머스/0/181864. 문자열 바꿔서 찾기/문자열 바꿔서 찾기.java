class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder(myString.length());
        for(int i = 0; i < myString.length(); i++){
            if (myString.charAt(i) == 'A'){
                sb.append("B");
            }else{
                sb.append("A");
            }
        }
        return sb.toString().contains(pat) ? 1 : 0;
    }
}