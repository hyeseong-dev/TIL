

import java.io.*;


public class Main {
    private static int CHUNK_SIZE = 10;
    public static void main(String[] args) throws IOException {
/**
 * 문제
 * 알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
 *
 * 한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 단어가 주어진다. 단어는 알파벳 소문자와 대문자로만 이루어져 있으며, 길이는 100을 넘지 않는다. 길이가 0인 단어는 주어지지 않는다.
 *
 * 출력
 * 입력으로 주어진 단어를 열 개씩 끊어서 한 줄에 하나씩 출력한다. 단어의 길이가 10의 배수가 아닌 경우에는 마지막 줄에는 10개 미만의 글자만 출력할 수도 있다.
 */

        //         입력 데이터를 명시적으로 작성
//        String input =  "BaekjoonOnlineJudge";
//        String input =  "OneTwoThreeFourFiveSixSevenEightNineTen";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader(input));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String chunkString = br.readLine();
        int length = chunkString.length();

        for(int i = 0; i < length; i += CHUNK_SIZE){
            int end = Math.min(length, i + CHUNK_SIZE);
            String unitString =chunkString.substring(i, end);
            bw.write(unitString);
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }
}

