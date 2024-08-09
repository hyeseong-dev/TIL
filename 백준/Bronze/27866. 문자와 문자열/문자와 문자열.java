import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String rawStr = br.readLine();
            int idx = Integer.parseInt(br.readLine()) - 1;
            System.out.println(rawStr.charAt(idx));
        }
    }
}
