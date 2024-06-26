import java.util.*;
class Solution {
    public String solution(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c: s.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(char c: charMap.keySet()){
            if(charMap.get(c) == 1){
                sb.append(c);
            }
        }
        char[] charArr = sb.toString().toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}