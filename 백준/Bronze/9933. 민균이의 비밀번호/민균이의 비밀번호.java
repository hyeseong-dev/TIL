import java.io.*;
import java.util.HashSet;
import java.util.Set;

// 기존 Main 클래스의 코드의 중복성을 줄이고 재사용성을 높이고 가독성 향상에 초점
public class Main {

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
        // try-with-resources 문을 사용하여 자원을 자동으로 닫도록 처리
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
