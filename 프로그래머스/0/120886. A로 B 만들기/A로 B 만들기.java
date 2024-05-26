import java.util.*;
class Solution {
    public int solution(String before, String after) {
        char beforeCharArray[] = before.toCharArray();
        char afterCharArray[] = after.toCharArray();
        Arrays.sort(beforeCharArray);
        Arrays.sort(afterCharArray);
        return new String(beforeCharArray).equals(new String (afterCharArray)) ? 1 : 0;

    }
}