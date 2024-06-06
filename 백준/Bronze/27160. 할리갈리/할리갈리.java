import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static Map<String, Integer> fruitFactory(){
        Map<String, Integer> fruits = new HashMap<>();
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
        scanner.nextLine(); // 개행 문자 처리

        Map<String, Integer> fruits = fruitFactory();

        for (int i = 1; i <= scNum; i++) {
            String strRaw = scanner.nextLine();
            String[] strList = strRaw.split(" ");
            String fruitName = strList[0];
            int fruitNum = Integer.parseInt(strList[1]);
            fruits.put(fruitName, fruits.get(fruitName) + fruitNum);
        }

        // HashSet을 이용해 5개의 과일이 존재하는지 확인
        Set<Integer> fruitCounts = new HashSet<>(fruits.values());
        if (fruitCounts.contains(5)) {
            answer = "YES";
        }

        System.out.println(answer);
        scanner.close();
    }
}
