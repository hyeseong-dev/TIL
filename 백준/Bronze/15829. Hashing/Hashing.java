
// 메모리 :
// 시간 :

import java.io.*;

public class Main {
    static int LOWERCASE_NUM = 96;
    static int PRIME31 = 31;

    static String solution(BufferedReader br) throws IOException{

        int cycle = Integer.parseInt(br.readLine());
        char[] charArray = br.readLine().toCharArray();
        long answer = 0L;

        for(int i = 0; i < cycle; i++){
            long num = (charArray[i] - LOWERCASE_NUM);
            long powNum = (long) Math.pow(PRIME31, i);
            answer = answer + (num * powNum);
        }
        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String answer = solution(br);
            bw.write(answer);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

