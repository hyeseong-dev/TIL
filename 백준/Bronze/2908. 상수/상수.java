import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static int solution(String[] rawList){
        int answer = 0;

        // 배열의 크기가 1개인 경우
        if(rawList.length == 1){
            StringBuffer sb = new StringBuffer(rawList[0]);
            String reversedStr = sb.reverse().toString();
            answer = Integer.parseInt(reversedStr);

        // 배열의 크기가 2개인 경우
        }else{

            for(String str: rawList){

                StringBuffer sb = new StringBuffer(str);
                String tmpDigit = sb.reverse().toString();
                int tmpNum = Integer.parseInt(tmpDigit);

                if(tmpNum > answer) answer = tmpNum;


            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = null; // Declare scanner outside try block
        try {
            scanner = new Scanner(System.in);
            String raw = scanner.nextLine();
            String[] rawList = raw.split(" ");

            System.out.println(solution(rawList));

        } catch (InputMismatchException e) {
            System.out.println("=========요류가 발생했습니다==========");
            System.out.println(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
