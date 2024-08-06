import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            int[] intArr = new int[N];

            for (int i = 0; i < N; i++) {
                intArr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(intArr);
            for(int i=0; i< N; i++){
                System.out.println(intArr[i]);
            }
        }

    }
}