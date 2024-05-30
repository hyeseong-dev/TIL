import java.util.*;
import java.util.stream.Collector;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> numMap = new HashMap<Integer, String>();
        numMap.put(1, "one");
        numMap.put(2, "two");
        numMap.put(3, "three");
        numMap.put(4, "four");
        numMap.put(5, "five");
        numMap.put(6, "six");
        numMap.put(7, "seven");
        numMap.put(8, "eight");
        numMap.put(9, "nine");
        numMap.put(0, "zero");

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        //TreeSet<String> digitSet = new TreeSet<>(); // 이름을 역순으로 정렬하는 TreeSet
        Map<Integer, String> digitMap = new LinkedHashMap<>();

        for(int i = N; i<=M; i++){
            String digit = "";
            if(i >= 10){
                String[] strList = String.valueOf(i).split("");

                int front = Integer.parseInt(strList[0]);
                int back = Integer.parseInt(strList[1]);
                digit = numMap.get(front) + " " + numMap.get(back);
            }else{
                digit = numMap.get(i);
            }
            digitMap.put(i, digit);
        }
        // 엔트리 리스트를 값 기준으로 정렬하기
        List<Map.Entry<Integer, String>> sortedEntries = new ArrayList<>(digitMap.entrySet());
        Collections.sort(sortedEntries, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> entry1, Map.Entry<Integer, String> entry2) {
                return entry1.getValue().compareTo(entry2.getValue());
            }
        });

        StringBuilder outputBuffer = new StringBuilder(); // 결과를 저장할 StringBuilder 생성

        int count = 0; // 숫자가 출력된 횟수를 나타내는 변수를 0으로 초기화합니다.

        for (Map.Entry<Integer, String> entry : sortedEntries) {
            if (count == 10) { // 10개의 숫자가 출력된 후에는 줄 바꿈을 합니다.
                outputBuffer.append("\n");
                count = 0; // 숫자가 출력된 횟수를 초기화합니다.
            }
            if (count > 0) { // 첫 번째 숫자가 아닌 경우에는 공백을 출력합니다.
                outputBuffer.append(" ");
            }
            outputBuffer.append(entry.getKey()); // 숫자를 StringBuilder에 추가합니다.
            count++; // 숫자가 출력된 횟수를 증가시킵니다.
        }

        // StringBuilder에 저장된 결과를 한 번에 출력합니다.
        System.out.print(outputBuffer.toString());

    }
}
