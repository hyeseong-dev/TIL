import java.util.*;
class Solution {
    public long solution(String numbers) {
        HashMap<String, String> numMap = new HashMap<>();
        numMap.put("zero", "0");
        numMap.put("one", "1");
        numMap.put("two", "2");
        numMap.put("three", "3");
        numMap.put("four", "4");
        numMap.put("five", "5");
        numMap.put("six", "6");
        numMap.put("seven", "7");
        numMap.put("eight", "8");
        numMap.put("nine", "9");

        StringBuffer sb = new StringBuffer();
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < numbers.length(); i++) {
            sb.append(numbers.charAt(i));
            if (numMap.containsKey(sb.toString())) {
                answer.append(numMap.get(sb.toString()));
                sb.setLength(0);
            }

        }

        return Long.parseLong(answer.toString());
}
}