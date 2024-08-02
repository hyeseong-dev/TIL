import java.io.*;
import java.util.Arrays;

public class Main {
    private static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int A = intArr[0];
        int B = intArr[1];
        int V = intArr[2];
        int dailyProgress = A - B; // 하루 실제 올라가는 높이
        int heightToClimb = V - A; // 마지막날을 제외하고 올라가야하는 높이
        int days = (int) Math.ceil((double) heightToClimb / dailyProgress);
        bw.write(String.valueOf(days + 1));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        solution(br, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    }

