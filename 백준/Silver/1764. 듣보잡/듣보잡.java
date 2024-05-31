import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // 입력 데이터를 명시적으로 작성
//        String input = "3 4\n" +
//                "ohhenrie\n" +
//                "charlie\n" +
//                "baesangwook\n" +
//                "obama\n" +
//                "baesangwook\n" +
//                "ohhenrie\n" +
//                "clinton\n";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader(input));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        Map<String, Integer> hashMap = new HashMap<>();
        Set<String> treeSet = new TreeSet<>();
        for(int i = 0; i < N+M; i++){
            String name = br.readLine();
            if(hashMap.get(name) != null){
                treeSet.add(name);
            }
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        bw.write(String.valueOf(treeSet.size())); // 결과 개수 출력
        bw.newLine(); // 새로운 줄에 출력
        for(String name : treeSet){
            bw.write(name); // 결과 출력
            bw.newLine(); // 새로운 줄에 출력
        }
        bw.flush(); // 버퍼 비우기
        bw.close(); // BufferedWriter 닫기
//        bw.write(treeSet.toString());
//        bw.flush();
//        bw.close();
    }
}
