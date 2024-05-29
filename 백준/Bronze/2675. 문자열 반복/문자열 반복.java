import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void solution(List<String> strList) {
        for (String str : strList) {

            if (str == null || str.length() < 3) {
                continue;
            }

            String[] parts = str.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input format.");
                continue;
            }

            try {
                int num = Integer.parseInt(parts[0]);
                String strBack = parts[1];

                StringBuilder sb = new StringBuilder();
                for (char ch : strBack.toCharArray()) {
                    String repeatedStr = String.valueOf(ch).repeat(num);
                    sb.append(repeatedStr);
                }
                System.out.println(sb.toString());
            } catch (NumberFormatException e) {
                System.out.println("Invalid repetition count.");
                continue;
            }
        }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> strList = new ArrayList<>();

        try{
            String str;

            while ((str = br.readLine()) != null && !str.isEmpty()) {
                strList.add(str);
            }

        }catch(IOException e){
            throw new RuntimeException((e));
        }

        if (strList.isEmpty()) {
            return;
        }
        solution(strList);

    }
}
