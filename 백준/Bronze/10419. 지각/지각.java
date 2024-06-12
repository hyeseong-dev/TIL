import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int d = Integer.parseInt(br.readLine());
            //최대로 올 수 있는 값 max.
            int max = 1;

            //교수님이 들어오자마자 끝내주는경우도 있다 했으니 작거나 같다.
            while(max + (max * max) <= d) {
                max++;
            }
            //-1하는 이유는 해당 조건 범위를 벗어 난 뒤에야 max갑에 1더하는 걸 멈추는데.
            //그렇게되면 가능한 범위를 하나 넘어가 버린다. 그렇기에 -1해준다.
            System.out.println((max - 1));
        }
        br.close();
    }

}