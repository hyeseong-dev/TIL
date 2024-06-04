import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ipv6 = br.readLine().trim();
        System.out.println(expandIPv6(ipv6));
    }

    public static String expandIPv6(String ipv6) {
        String[] parts = ipv6.split("::", -1); // "::"으로 분할, -1은 빈 문자열도 포함하여 분할
        String[] left = parts[0].split(":");
        String[] right = (parts.length == 2) ? parts[1].split(":") : new String[0];

        // 확장된 IPv6 주소를 담을 배열
        String[] fullAddress = new String[8];
        int leftIndex = 0;
        
        // 왼쪽 부분 채우기
        for (int i = 0; i < left.length; i++) {
            fullAddress[leftIndex++] = left[i];
        }

        // 오른쪽 부분 채우기
        int rightIndex = 7;
        for (int i = right.length - 1; i >= 0; i--) {
            fullAddress[rightIndex--] = right[i];
        }

        // 빈 부분 0으로 채우기
        for (int i = 0; i < 8; i++) {
            if (fullAddress[i] == null || fullAddress[i].isEmpty()) {
                fullAddress[i] = "0000";
            } else {
                fullAddress[i] = String.format("%4s", fullAddress[i]).replace(' ', '0');
            }
        }

        // 결과 조합
        return String.join(":", fullAddress);
    }
}
