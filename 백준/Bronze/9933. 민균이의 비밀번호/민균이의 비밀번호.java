import java.io.*;
import java.util.HashSet;
import java.util.Set;

// Main2 클래스 코드의 시간복잡도를 향상
public class Main {

    /**
     * [리팩토링된 코드 설명]
     *      1. 문자열 배열을 순회하는 루프: O(n)
     *      2. 각 문자열에 대해 팰린드롬 여부를 확인하는 루프: O(1) (문자열 길이 상수)
     *      3. HashSet을 사용하여 문자열의 존재 여부를 확인하는 부분: O(1)
     *         - 문자열을 저장할 때 HashSet을 사용하여 문자열의 존재 여부를 O(1)에 확인할 수 있습니다.
     *         - 이는 Arrays.asList().contains()를 사용하는 것보다 효율적입니다.
     *
     *      결론:  최종 시간 복잡도는 O(n)으로, 이전 코드의 O(n^2)에 비해 크게 개선
     */
    public static String solution(BufferedReader br) throws IOException {
        int cycles = Integer.parseInt(br.readLine());
        Set<String> stringSet = new HashSet<>();

        // cycles 만큼 loop를 돌며 문자열 데이터를 버퍼에서 가져옵니다.
        for (int i = 0; i < cycles; i++) {
            String string = br.readLine();
            stringSet.add(string);

            // 팰린드롬인지 확인
            if (isPalindrome(string)) {
                return String.format("%d %s", string.length(), string.charAt(string.length() / 2));
            }
        }

        // 특정 문자열(reverse 처리한)이 문자열 집합에 존재하는지 확인
        for (String string : stringSet) {
            String reversedString = new StringBuilder(string).reverse().toString();
            if (stringSet.contains(reversedString)) {
                return String.format("%d %s", reversedString.length(), reversedString.charAt(reversedString.length() / 2));
            }
        }

        return "";
    }

    // 팰린드롬 여부를 확인하는 메서드
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String answer = solution(br);
            bw.write(answer);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 *
 * [왜? 배열보다 HashSet을 쓰는 것이 빠른가?]
 *      1. Arrays.asList().contains()의 시간 복잡도
 *       - Arrays.asList(array)는 주어진 배열을 리스트로 변환합니다.
 *         변환된 리스트에서 contains(element) 메서드를 호출하면 리스트의 각 요소를 순차적으로 비교하여 일치하는 요소가 있는지 확인합니다.
 *
 *       - 시간 복잡도: 이 과정은 리스트의 길이에 비례하는 O(n)의 시간 복잡도를 가집니다.
 *                   즉, 리스트의 모든 요소를 검사해야 하기 때문에 최악의 경우 리스트의 길이 n 만큼 시간이 걸립니다.
 *
 *      2. HashSet의 시간 복잡도
 *        - HashSet은 해시 테이블을 기반으로 하는 데이터 구조입니다.
 *          요소를 저장할 때 해시 함수를 사용하여 요소를 특정 버킷에 매핑합니다.
 *          요소를 검색할 때도 같은 해시 함수를 사용하여 해당 버킷에서 요소를 찾습니다.
 *
 *        - 시간 복잡도: 요소의 삽입, 삭제 및 검색의 평균 시간 복잡도는 O(1)입니다.
 *                    해시 충돌이 발생하는 경우에도 충돌이 적절히 해결되면 O(1)에 가깝게 동작합니다.
 *                    따라서 HashSet을 사용하면 매우 빠르게 요소의 존재 여부를 확인할 수 있습니다.
 *      3. 결론
 *        - 속도: HashSet의 평균 시간 복잡도는 O(1)인 반면, Arrays.asList().contains()의 시간 복잡도는 O(n)입니다.
 *               큰 데이터 세트의 경우, HashSet이 훨씬 빠르게 동작합니다.
 *               
 *        - 효율성: HashSet은 해시 테이블을 사용하여 요소를 저장하고 검색하므로, 효율적인 요소 검색이 가능합니다.
 *                반면, 리스트의 경우 순차 탐색을 해야 하므로 비효율적입니다.
 */