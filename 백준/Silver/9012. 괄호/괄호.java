

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static String solution(BufferedReader br) throws IOException {
        br.readLine();

        List<String> answerList = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            String answer = "NO";
            // 인덱스 0이 ')'로 시작 || 인덱스(line.length-1)이 '('라면 loop를 종료한다.
            // 그리고 "NO" 값을 가진 answer를 리턴한다.
            if (line.charAt(0) == ')' || line.charAt(line.length() - 1) == '(') {
                answerList.add(answer);
                continue;
            }

            Stack<Character> stack = new Stack<>();
            // 앞서 if조건을 통해 0인덱스와 마지막 인덱스를 탐색하였으므로 해당 인덱스를 제외한 구간을 처리한다.
            for (int i = 0; i < line.length(); i++) {


                // stack에 내용물(O) -> top 내용물이 '('이고, line 인덱싱한 데이터가 ')'인 경우 ==> POP
                if (!stack.isEmpty() && stack.peek() == '(' && line.charAt(i) == ')') {
                    stack.pop();

                    // 1) stack에 내용물(0) -> top 내용물이 ')', line 인덱싱한 데이터가 ')'==> PUSH
                    // 2) stack에 내용물(X) ----------------> line 인덱싱한 데이터가 '(' ==> PUSH
                } else {
                    stack.push(line.charAt(i));
                }
            }
            answer = stack.isEmpty() ? "YES" : "NO";
            answerList.add(answer);
        }
        return String.join("\n", answerList);

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
