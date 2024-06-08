

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static String solution(BufferedReader br) throws IOException {

        String braces = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < braces.length(); i++) {
            if(!stack.empty() && stack.peek() == '(' && braces.charAt(i) == ')') {
                stack.pop();
            }else{
                stack.push(braces.charAt(i));
            }
        }
        int count = stack.size();


        return String.valueOf(count);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = solution(br);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }

}
