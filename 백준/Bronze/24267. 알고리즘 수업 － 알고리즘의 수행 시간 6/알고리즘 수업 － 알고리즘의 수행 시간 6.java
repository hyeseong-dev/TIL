import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long number = Integer.parseInt(br.readLine()); //Int

        System.out.println(((number - 2) * (number - 1) * number) / 6);
        System.out.println(3);
    }
}
