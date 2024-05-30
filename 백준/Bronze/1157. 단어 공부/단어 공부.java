import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /**
     * 1. solution 메서드는 문자열에서 가장 많이 나오는 문자를 찾습니다.
     *
     * 2. 입력받은 문자열(word)을 모두 소문자로 변환한 후, 각 문자를 char[] 타입의 chars에 할당합니다.
     * 3. 그 다음, 각 문자의 등장 횟수를 저장하기 위한 HashMap을 생성합니다.
     *
     * 4. chars 배열을 순회하면서 각 문자가 charMap에 이미 알파벳이 존재하는지 확인하고, 등장 횟수를 증가시킵니다.
     * 5. 이렇게 하면 각 문자의 등장 횟수를 charMap에 저장할 수 있습니다.
     *
     * 6. 가장 많이 등장한 문자와 해당 횟수를 저장하기 위해 maxCount와 maxOccuranceChar 변수를 초기화합니다.
     *
     * 7. charMap을 순회하면서 가장 많이 등장한 문자를 찾습니다.
     * 8. 각 문자의 등장 횟수를 변수 count를 통해 확인하고, 현재까지의 최대 등장 횟수와 if조건으로 비교합니다.
     * 9. 만약 더 많이 등장한 문자를 찾으면, 최대 등장 횟수와 해당 문자를 갱신합니다.
     * 10. 만약 최대값이 같은 다른 문자가 존재한다면, maxOccuranceChar를 '?'로 설정하여 중복 됨을 표현합니다.
     *
     * 11. maxOccuranceChar를 반환하여 가장 많이 등장한 문자 혹은 동일한 최대값인 `?`를 출력합니다.
     *
     */

    public static char solution(String word){

        // 설명 2, 3
        char[] chars = word.toLowerCase().toCharArray(); // 문자를 모두 소문자로 변경 후, char[]에 할당
        HashMap<Character, Integer> charMap = new HashMap<>(); // 각 캐릭터의 key, value를 처리 할 변수 선언

        // 설명 4, 5
        for (char chr : chars) {
            int count = charMap.getOrDefault(chr, 0);
            charMap.put(chr, count + 1);
        }

        // 설명 6번
        int maxCount = 0;
        char maxOccuranceChar = '?';

        // 설명 7 ~ 10
        for(Map.Entry<Character, Integer> entry: charMap.entrySet()){
            int count = entry.getValue();
            if(count > maxCount){
                maxCount = count;
                maxOccuranceChar = entry.getKey();
            }else if(count == maxCount){
                maxOccuranceChar = '?';
            }
        }
        return maxOccuranceChar == '?' ?  maxOccuranceChar : Character.toUpperCase(maxOccuranceChar);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        System.out.println(solution(word));

    }
}
