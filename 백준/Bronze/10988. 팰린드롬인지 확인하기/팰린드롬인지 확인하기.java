import java.io.*;
import java.util.Stack;


public class Main {
    static int solution(BufferedReader br) throws IOException{
        int answer = 0;
        String rawString = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<rawString.length(); i++){
            stack.push(rawString.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        if(sb.toString().equals(rawString)){
            answer = 1;
            return answer;
        }
        return answer;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = solution(br);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}