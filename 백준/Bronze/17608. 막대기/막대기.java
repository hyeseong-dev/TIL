import java.io.*;
import java.util.Stack;


public class Main {

    static int solution(BufferedReader br) throws IOException{
        int cycle = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < cycle; i++){
            int num = Integer.parseInt(br.readLine().trim());
            stack.push(num);
        }
        int visibleCount = 1;
        int longestBar = stack.pop();
        while(!stack.isEmpty()){
            int nextBar = stack.pop();
            if (nextBar > longestBar){
                longestBar = nextBar;
                visibleCount++;
            }
        }
        
        return visibleCount;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = solution(br);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }


}
