import java.util.HashMap;
import java.util.Map;

class Solution {
    private String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    private char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public String solution(String letter) {
        String answer = "";
        Map<String, Character> morseToChar = new HashMap<>();

        for (int i = 0; i < this.morseCodes.length; i++) {
            morseToChar.put(this.morseCodes[i], this.characters[i]);
        }

        for(String str : letter.split(" ")){
            answer += morseToChar.get(str);
        }

        return answer;
    }
}