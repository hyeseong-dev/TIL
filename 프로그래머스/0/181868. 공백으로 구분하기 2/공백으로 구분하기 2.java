import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        // 문자열의 양 끝에 있는 공백 제거
        my_string = my_string.trim();
        
        // 문자열에서 공백을 기준으로 분리
        String[] words = splitBySpace(my_string);
        
        return words;
    }
    
    // 공백을 기준으로 문자열을 나누는 메서드
    private String[] splitBySpace(String str) {
        // 문자열을 공백을 기준으로 나누어 배열에 저장
        String[] words = str.split(" ");
        
        // 빈 문자열 제거
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordList.add(word);
            }
        }
        
        // 리스트를 배열로 변환하여 반환
        return wordList.toArray(new String[0]);
    }
}