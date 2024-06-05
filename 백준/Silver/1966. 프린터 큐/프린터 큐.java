import java.io.*;
import java.util.*;

public class Main {

    static String solution(BufferedReader br, BufferedWriter bw) throws IOException{
        int cycle = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        while(cycle-- > 0){
            st = new StringTokenizer(br.readLine());
            int numDoc = Integer.parseInt(st.nextToken());
            int curDocIdx = Integer.parseInt(st.nextToken());

            // 큐와 우선순위 리스트 초기화
            Queue<int[]> queue = new LinkedList<>();
            List<Integer> priorityArr = new ArrayList<>();

            // queue, priorityArr에 값을 할당하여 채워줍니다.
            String[] strArr = br.readLine().split(" ");
            for(int i = 0 ; i < strArr.length ; i++){
                int priority = Integer.valueOf(strArr[i]);
                queue.offer(new int[]{i, priority});  // 큐에( {위치 인덱스, 우선순위} ) 저장
                priorityArr.add(priority);
            }


            // priorityArr를 DESC로 정렬합니다.
            Collections.sort(priorityArr, Collections.reverseOrder());
            int printOrder = 0;

            // queue가 모두 빌 때까지 loop를 돌립니다.
            while(!queue.isEmpty()){

                // 큐에서 일단 값을 꺼내고 idx, priority변수에 각각 0, 1번째 인덱스에 맞게 할당합니다.
                int[] currentArr = queue.poll();
                int idx = currentArr[0];
                int priority = currentArr[1];

                // 우선순위만 담긴 배열의 인덱스와 큐에서 가져온 idx는 일치하다면 다음 로직 처리를 합니다.
                if(priorityArr.get(0) == priority){

                    printOrder++; // 우선순위만 담긴 배열을 printOrder를 증가시킵니다.
                    priorityArr.remove(0); // 우선순위만 담긴 배열의 맨 앞의 값을 삭제해줍니다.
                    if(idx == curDocIdx){
                        result.append(printOrder).append("\n");
                        break;
                    }

                } else{
                    // 우선순위만 담긴 배열의 인덱스와 큐에서 가져온 idx가 일치하지 않는다면
                    // currentArr를 다시 큐에 넣습니다.
                    queue.offer(currentArr);
                }

            }
        }

        return result.toString();
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = solution(br, bw);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}