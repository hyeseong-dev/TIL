
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int TEN_MUSHROOM = 10;
    static final int HUNDRED_MUSHROOM = 100;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mushRoomArr = new int[TEN_MUSHROOM];
        StringTokenizer st;

        int score = 0;
        for (int i = 0; i < TEN_MUSHROOM; i++) {
            st = new StringTokenizer(br.readLine());
            mushRoomArr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for(int mushroom : mushRoomArr){
            score += mushroom;
            if(score >= HUNDRED_MUSHROOM){
                if(score - 100 > 100 - (score - mushroom)){
                    score -= mushroom;
                }
                break;
            }
        }
        System.out.println(score);
    }
}
