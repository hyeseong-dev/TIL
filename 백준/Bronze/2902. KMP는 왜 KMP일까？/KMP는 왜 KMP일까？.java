
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//         입력 데이터를 명시적으로 작성
//        String input =  "Knuth-Morris-Pratt";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader(input));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] wordArr = br.readLine().split("-");
        int N = wordArr.length;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){

            sb.append(wordArr[i].charAt(0));
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

