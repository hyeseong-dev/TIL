import java.util.Scanner;

public class Main {
    /**
     * 시간 복잡도 : O(n)
     *   - 이유 : 입력 문자열의 길이에 선형적으로 비례하여 실행 시간이 증가하기 때문입니다.
     *
     * 공간 복잡도 : O(1)
     *   - 이유 : 입력 문자열을 단어로 분할하여 루프를 실행하므로 추가 메모리가 필요하지 않습니다.
     *           따라서 공간 복잡도는 입력에 관계없이 상수 크기의 메모리를 사용합니다.
     *
     * @param  String strList : 스캐너를 통해 입력 받는 문자열
     * @return int    count   : 정수 반환 값
     *
     */
    public static int solution(String strList) {
        int count = 0;
        boolean prevSpace = true; // 이전 문자가 공백인지 여부를 나타내는 플래그

        for (char c : strList.toCharArray()) {
            if (c == ' ') {
                prevSpace = true; // 공백 문자를 만나면 플래그를 설정
            } else {
                // 공백 문자를 만나지 않은 경우, 이전 문자가 공백이었다면 단어 수를 증가시킴
                if (prevSpace) {
                    count++;
                }
                prevSpace = false; // 이전 문자가 공백이 아님을 나타내는 플래그 설정
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        System.out.println(solution(s));

        scanner.close();
    }
}
