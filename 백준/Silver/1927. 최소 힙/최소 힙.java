import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static String solution(BufferedReader br) throws IOException{
        int cycle = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        List<String> results = new ArrayList<>();
        while (cycle-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty()){
                    results.add("0");
                } else{
                    int min = pq.poll();
                    String minStr = String.valueOf(min);
                    results.add(minStr);
                }
            }else{
                pq.offer(num);
            }

        }
        return String.join("\n", results);
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
