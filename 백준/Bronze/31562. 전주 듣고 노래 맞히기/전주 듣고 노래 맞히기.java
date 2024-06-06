
import java.io.*;
import java.util.*;

public class Main {

    static String solution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<String>> map = new HashMap<>(N);
        StringBuilder sb = new StringBuilder();

        while(N-- >0){

            // 곡의 길이, 곡이름, 음 정보
            String[] line = br.readLine().split(" ");
            String name = line[1];
            String notes = slicing(line);


            /**
             * 람다 표현식 k -> new ArrayList<>()은 새로운 ArrayList 인스턴스를 생성하여 반환하는데,
             * 이것이 notes에 해당하는 키에 대한 값으로 설정됩니다.
             * 따라서 만약 notes에 해당하는 값이 이미 존재한다면 해당 값이 반환되고,
             *      없다면 새로운 빈 ArrayList가 생성되어 맵에 추가됩니다.
             */
            // map에서 notes를 키로 사용하여 값 가져오기
            List<String> nameList = map.computeIfAbsent(notes, k -> new ArrayList<>());
            nameList.add(name);

        }

        Set<String> set = new HashSet<>(M);
        while(M-- >0){
        String notes = br.readLine();

            if(map.containsKey(notes) && (map.get(notes).size() > 1)){
                sb.append("?").append("\n");
            }else if(map.containsKey(notes) && (map.get(notes).size() == 1)){
                String name = map.get(notes).get(0);
                sb.append(name).append("\n");
            }else{
                sb.append("!").append("\n");
            }

        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    static String slicing(String[] strArr){
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < 5; i++){
            sb.append(strArr[i].concat(" "));
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
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
