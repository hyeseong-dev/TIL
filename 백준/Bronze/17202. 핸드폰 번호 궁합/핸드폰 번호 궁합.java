

import java.io.*;

public class Main {
    static final int DIVIDER_TEN = 10;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new StringReader(input1()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 핸드폰 번호 입력
        String phoneNumberA = br.readLine();
        String phoneNumberB = br.readLine();

        // 번갈아가며 병합한 문자열 생성
        StringBuilder mergedPhoneNumbers = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            mergedPhoneNumbers.append(phoneNumberA.charAt(i)).append(phoneNumberB.charAt(i));
        }

        // 병합된 문자열을 리스트로 변환
        int[] phoneNumberDigits = new int[16];
        for (int i = 0; i < 16; i++) {
            phoneNumberDigits[i] = Character.getNumericValue(mergedPhoneNumbers.charAt(i));
        }

        // 인접한 두 숫자를 더한 값의 일의 자리를 계산 (두 포인터 방식)
        while (phoneNumberDigits.length > 2) {
            int[] newPhoneNumberDigits = new int[phoneNumberDigits.length - 1];
            int left = 0;
            int right = 1;
            int index = 0;
            while (right < phoneNumberDigits.length) {
                newPhoneNumberDigits[index++] = (phoneNumberDigits[left] + phoneNumberDigits[right]) % DIVIDER_TEN;
                left++;
                right++;
            }
            phoneNumberDigits = newPhoneNumberDigits;
        }

        // 결과 출력
        for (int digit : phoneNumberDigits) {
            bw.write(String.valueOf(digit));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 예제 출력1 26
    static String input1() {
        return "74759336\n" + "36195974";
    }

    // 예제 출력2 02
    static String input2() {
        return "01234567\n" + "12345678";
    }
}
