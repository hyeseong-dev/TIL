
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rawStr = br.readLine();
        String sorry = "I'm sorry Hansoo";
        // int타입의 배열 arr를 26으로 크기 할당 한 이유는 알파벳이 A~Z까지 총 26개 이기 때문
        int[] arr = new int[26];
        for(int i=0;i<rawStr.length();i++){

            // ASCII 값에서 'A"를 빼면 정수가 나옴 'B' -'A' => 1 , 'Z' - 'A' => 26
            int index = rawStr.charAt(i) - 'A';
            arr[index] = arr[index]+1;
        }

        /*
        [주어진 문자열이 팰린드롬으로 만들 수 있는지를 확인하는 과정]
        1. 각 문자가 몇 번 등장했는지를 카운팅하기
        2. 홀수 번 등장한 문자의 개수를 확인

        1) odd라는 변수를 생성함. 이는 홀수의 개수를 찾는데 사용.
        2) 홀수인 문자가 2개 이상 나오면 팰린드롬을 만들 수 없으므로 `Sorry`라는 문자를 리턴 할 거임
            -> 예) ABBBC, AAABBB, AAABBBC,

        3) odd 변수는 홀수 번 등장한 문자의 개수를 저장합니다. 초기값은 0입니다.
        4) num 변수는 홀수 번 등장한 문자의 인덱스를 저장합니다.
          이 변수는 홀수 번 등장한 문자가 단 하나만 있는 경우에 해당 문자를 팰린드롬의 중앙에 위치시킬 것입니다. 초기값은 0입니다.

        5) 배열 arr을 순회하면서 각 문자의 등장 횟수를 확인합니다.
        6) 만약 현재 문자의 등장 횟수가 홀수 번이라면, odd를 1 증가시키고, num에 현재 인덱스를 저장합니다.
        7) 만약 odd가 2 이상이라면, 문자열을 팰린드롬으로 만들 수 없으므로 "I'm Sorry Hansoo"를 출력하고 함수를 종료합니다.
        결론 : 첫 for loop는 문자열이 팰린드롬으로 만들 수 있는지를 확인하는 과정 중에서,
              홀수 번 등장한 문자가 2개 이상인 경우에는 팰린드롬으로 만들 수 없다는 것을 검사합니다.
        */
        int odd = 0;
        int num = 0;
        for(int i=0; i<arr.length; i++){

            if (arr[i] % 2 != 0) {
                odd++;
                num = i;
            }
            if (odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                sb.append((char)(i+'A'));
            }
        }
        String result = sb.toString();
        if (odd == 1) {
            result += (char) (num + 'A');
        }
        result += sb.reverse().toString();
        System.out.println(result);

    }

}
