

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1번째 라인의 입력 M을 받는다.
        long N = Integer.parseInt(br.readLine());
        Set<Long> A = new HashSet<>((int) N);
        String[] strArr;

        // br로 부터 입력 받는 '4 1 5 2 3 문자열'크기5의 정수 배열로 변환한다.
        strArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A.add(Long.parseLong(strArr[i]));
        }

        // 3번째 라인의 입력 M을 받는다.
        long M = Long.parseLong(br.readLine());
        strArr = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if(A.contains(Long.parseLong(strArr[i]))){
                bw.write("1");
            }else{
                bw.write("0");
            }

            if(i!=M-1) bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

