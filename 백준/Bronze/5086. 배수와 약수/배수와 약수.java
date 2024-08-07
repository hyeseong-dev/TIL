
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String rawStr;
            while((rawStr = br.readLine()) != null && !rawStr.equals("0 0")){
                int[] intArr = Arrays.stream(rawStr.split(" ")).mapToInt(Integer::parseInt).toArray();
                boolean isfactor = (intArr[1] % intArr[0] == 0);
                boolean isMultiple = (intArr[0] % intArr[1] == 0);
                if(isfactor) System.out.println("factor");
                if(isMultiple) System.out.println("multiple");
                if (!isMultiple && !isfactor) {
                    System.out.println("neither");
                }
            }

        }
    }
}
