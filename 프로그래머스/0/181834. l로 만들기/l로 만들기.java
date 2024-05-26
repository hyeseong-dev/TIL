class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();

        char l = 'l';

        for (int i = 0; i < myString.length(); i++) {
            char addingChar;
            if ( (int) myString.charAt(i) < (int) l ){
                addingChar = l;
            }else{
                addingChar = myString.charAt(i);
            }
            sb.append(addingChar);

        }

        return sb.toString();
    }
}