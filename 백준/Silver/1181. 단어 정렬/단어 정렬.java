import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Set<String> strHashSet = new HashSet<>();

        // 입력 받으면서 중복 제거
        for(int i = 0; i< N; i++){
            strHashSet.add(br.readLine());
        }
        String[] strArr = strHashSet.toArray(new String[0]);
        Arrays.sort(strArr);
        Arrays.sort(strArr, (String s1, String s2) -> s1.length() - s2.length());
        for(int i = 0; i< strArr.length; i++){
            bw.write(strArr[i]);bw.newLine();
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        solution(br, bw);
        bw.flush();
        bw.close();
        br.close();
    }

}
