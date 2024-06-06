import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static Map<String, Integer> fruitFactory() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("BANANA", 0);
        fruits.put("PLUM", 0);
        fruits.put("LIME", 0);
        fruits.put("STRAWBERRY", 0);
        return fruits;
    }

    public static void main(String[] args) throws IOException {
        String answer = "NO";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int scNum = Integer.parseInt(reader.readLine());

        Map<String, Integer> fruits = fruitFactory();

        for (int i = 1; i <= scNum; i++) {
            String strRaw = reader.readLine();
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

        writer.write(answer);
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}
