import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long number = Integer.parseInt(br.readLine()); //Int


        System.out.println((number * (number -1))/2);
        System.out.println(2);
    }
}
