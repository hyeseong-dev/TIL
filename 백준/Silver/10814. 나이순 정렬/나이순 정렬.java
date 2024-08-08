import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            HashMap<Integer, List<String>> ageMap = new HashMap<>();

            for(int i = 0; i < N; i++){
                String[] rawStr = br.readLine().split(" ");
                int age = Integer.parseInt(rawStr[0]);
                String name = rawStr[1];

                List<String> names = ageMap.get(age);
                if(names == null){
                    names = new ArrayList<>();
                    ageMap.put(age, names);
                }
                names.add(name);
            }

            List<Integer> ages = new ArrayList<>(ageMap.keySet()); // 나이별 정렬된 결과를 가지기 위해 나이 리스트 정렬
            Collections.sort(ages);

            for(int age: ages){
                List<String> names = ageMap.get(age);
                for(String name : names){
                    System.out.println(age + " " + name);
                }
            }

        }

    }
}
