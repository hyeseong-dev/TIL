import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";

        Map<String, Integer> a = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            String key = s.charAt(i) + "";
            if(a.get(key) == null){
                a.put( key,  1);
            }else{
                a.put( key,  a.get(key) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(a.keySet());
        Collections.sort(keySet);

        for (String key : keySet) {
            if(a.get(key) == 1){
                answer += key;
            }

        }

        return answer;
    }
}