import java.io.*;
import java.util.Stack;


public class Main {

    static void solution(BufferedReader br, BufferedWriter bw) throws IOException{
        int cycle = Integer.parseInt(br.readLine().trim());

        Stack<String> stack = new Stack<>();
        int countCase = 1;
        String answer = "";
        while(cycle-- > 0){
            String line = br.readLine();
            // 문자형 배열로 변환합니다.
            String[] wordList = line.split(" ");

            // 문자가 담긴 배열을 빈 스택에 담아줍니다.
            for(String word : wordList){
                stack.push(word);
            }

            String[] answerList = new String[stack.size()];
            for(int i = 0; i < wordList.length; i++){
                String word = stack.pop();
                answerList[i] = word;
            }
            answer = String.format("Case #%d: %s", countCase, String.join(" ", answerList));
            bw.write(answer);
            bw.newLine();
            countCase++;
        }

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
