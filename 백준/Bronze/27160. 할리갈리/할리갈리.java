import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, Integer> fruitFactory(){
        // 4종 과일의 총 합이 5개일 경우 YES 그렇지 않으면 NO
        // 접근1 : HASHMAP으로 풀기
        Map<String, Integer> fruits = new HashMap<String, Integer>();
        fruits.put("BANANA", 0);
        fruits.put("PLUM", 0);
        fruits.put("LIME", 0);
        fruits.put("STRAWBERRY", 0);
        return fruits;
    }

    public static void main(String[] args) {
        String answer = "NO";

        Scanner scanner = new Scanner(System.in);
        int scNum = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리  / ** 중요 **

        // 4종 과일의 총 합이 5개일 경우 YES 그렇지 않으면 NO
        // 접근1 : HASHMAP으로 풀기
        Map<String, Integer> fruits = fruitFactory();


        for (int i = 1; i <= scNum; i++) {
            String strRaw = scanner.nextLine();
            String []strList = strRaw.split(" ");
            String fruitName = strList[0];
            int fruitNum = Integer.parseInt(strList[1]);
            fruits.put(fruitName, fruits.get(fruitName)+fruitNum);
        }

        for(Map.Entry<String, Integer> entry : fruits.entrySet()){
            if(entry.getValue() == 5 ) answer = "YES";
        }
        System.out.println(answer);
        scanner.close();
    }
}
