

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // 표준 입력에서 문자열을 읽습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alpha = br.readLine();
        
        // 크로아티아 알파벳 리스트를 정의합니다.
        List<String> croatiaAlphabets = Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");
        
        // 크로아티아 알파벳을 *로 치환합니다.
        for (String aVal : croatiaAlphabets) {
            alpha = alpha.replace(aVal, "*");
        }

        // 치환된 문자열의 길이를 출력합니다.
        System.out.println(alpha.length());
        
        br.close();
    }
}
