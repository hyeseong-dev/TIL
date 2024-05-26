import java.util.*;
class Solution {
    public int[] solution(String myString) {
        // "x"를 기준으로 문자열을 나눕니다.
        String[] splitStrings = myString.split("x", -1);
        
        // 각 부분 문자열의 길이를 저장할 배열을 생성합니다.
        int[] result = new int[splitStrings.length];
        
        // 각 부분 문자열의 길이를 배열에 저장합니다.
        for (int i = 0; i < splitStrings.length; i++) {
            result[i] = splitStrings[i].length();
        }
        
        return result;
}
}