import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 핸드폰 번호 입력
        String A = scanner.next();
        String B = scanner.next();

        // 번갈아가며 병합한 문자열 생성
        StringBuilder merged = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            merged.append(A.charAt(i)).append(B.charAt(i));
        }

        // 병합된 문자열을 리스트로 변환
        int[] nums = new int[16];
        for (int i = 0; i < 16; i++) {
            nums[i] = Character.getNumericValue(merged.charAt(i));
        }

        // 인접한 두 숫자를 더한 값의 일의 자리를 계산
        while (nums.length > 2) {
            int[] newNums = new int[nums.length - 1];
            for (int i = 0; i < nums.length - 1; i++) {
                newNums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = newNums;
        }

        // 결과 출력
        System.out.printf("%d%d\n", nums[0], nums[1]);
    }
}
