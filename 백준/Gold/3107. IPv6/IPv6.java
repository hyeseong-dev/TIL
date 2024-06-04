

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ipv6Address = br.readLine().trim();
        System.out.println(expandIPv6(ipv6Address));


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String expandIPv6(String ipv6Address) {
        // "::"으로 분할하여 parts 배열에 저장
        String[] parts = ipv6Address.split("::", -1); // "::"으로 분할, -1은 빈 문자열도 포함하여 분할
        String[] leftPart = parts[0].split(":");
        String[] rightPart = (parts.length == 2) ? parts[1].split(":") : new String[0];

        // 확장된 IPv6 주소를 담을 배열 생성
        String[] fullAddressArray = new String[8];
        int leftPartIndex = 0;

        // 왼쪽 부분을 fullAddressArray에 채우기
        for (int i = 0; i < leftPart.length; i++) {
            fullAddressArray[leftPartIndex++] = leftPart[i];
        }

        // 오른쪽 부분을 fullAddressArray에 채우기
        int rightPartIndex = 7;
        for (int i = rightPart.length - 1; i >= 0; i--) {
            fullAddressArray[rightPartIndex--] = rightPart[i];
        }

        // 빈 부분을 "0000"으로 채우기
        for (int i = 0; i < 8; i++) {
            if (fullAddressArray[i] == null || fullAddressArray[i].isEmpty()) {
                fullAddressArray[i] = "0000";
            } else {
                String formattedString = String.format("%4s", fullAddressArray[i]);
                fullAddressArray[i] = formattedString.replace(' ', '0');
            }
        }

        // 결과 조합
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fullAddressArray.length; i++) {
            result.append(fullAddressArray[i]);
            if (i < fullAddressArray.length - 1) {
                result.append(":");
            }
        }

        return result.toString();
    }

    // 테스트 입력 메서드
    static String input10() {
        return "::1:2:3:4:5:6";
    }
}
