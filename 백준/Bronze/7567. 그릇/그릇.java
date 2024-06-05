

// 메모리:  KB
// 속도:    ms


import java.io.*;

public class Main {


    static void solution(BufferedReader br, BufferedWriter bw) throws IOException{

        char[] chars = br.readLine().toCharArray();
        int num = 10;
        char previousShape = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char shape = chars[i];
            num += (previousShape == shape)? 5: 10;
            previousShape = shape;

        }
        bw.write(String.valueOf(num));
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        solution(br, bw);
        bw.flush();
        bw.close();
        br.close();
    }
}

