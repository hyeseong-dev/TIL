import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static String solution(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int cycles = Integer.parseInt(st.nextToken());

        String[] stringArr = new String[cycles];
        // cycle만큼 loop를 돌며 문자열 데이터를 버퍼에서 가져옵니다.
        for (int i = 0; i < cycles; i++) {
            String string = br.readLine();
            int loopNum =  string.length() / 2;

            boolean isPalindrome = true;
            // 버퍼에서 받아온 한줄의 문자를 팰린드롬 알고리즘의 투포인터로 확인처리함.
            for (int leftPointer = 0, rightPointer=string.length()-1;
                 leftPointer < loopNum;
                 leftPointer++, rightPointer--
            ){

                // 문자, 0번째 인덱스 <-> (마지막 인덱스) 값 일치여부 비교
                // 문자, 1번째 인덱스 <-> (마지막 인덱스 -1) 값 일치여부 비교
                // ... leftPointer 증가하고 rightPointer는 감소함.
                if(string.charAt(leftPointer) != string.charAt(rightPointer)){
                    isPalindrome = false;
                    break;
                }
            }

            if(isPalindrome){
                return String.format("%d %s", string.length(), string.charAt(loopNum));
            }else{
                stringArr[i] = string;
            }
        }

        // 특정 문자열(reverse 처리한)이 문자열 배열에 존재하는지 확인
        for(int i = 0; i < cycles; i++){
            String reversedString = new StringBuilder(stringArr[i]).reverse().toString();
            if(Arrays.asList(stringArr).contains(reversedString)){
                int midIdx = reversedString.length() /2;
                return String.format("%d %s", reversedString.length(), reversedString.charAt(midIdx));
            }
        }

        return "";

    }

    public static void main(String[] args) throws IOException {

        // try-with-resources 문을 사용하여 자원을 자동으로 닫도록 처리
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
