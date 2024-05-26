class Solution {
    public String solution(String myString) {
        StringBuilder answer = new StringBuilder(myString.length());

        for (int i = 0; i < myString.length(); i++) {
            char currentChar = myString.charAt(i);

            // 알파벳 "a"가 등장하면 전부 "A"로 변환
            if (currentChar == 'a') {
                answer.append('A');
            } else if (currentChar != 'A' && Character.isUpperCase(currentChar)) {
                // "A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환
                answer.append(Character.toLowerCase(currentChar));
            } else {
                answer.append(currentChar);
            }
        }
        
        return answer.toString();
    }
}