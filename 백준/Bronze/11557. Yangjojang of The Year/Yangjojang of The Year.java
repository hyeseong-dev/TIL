

import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cycle = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (cycle-- > 0) {
            int max = Integer.MIN_VALUE;
            String univName = "";
            int numUniv = Integer.parseInt(br.readLine());
            for(int i = 0; i < numUniv; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int amount = Integer.parseInt(st.nextToken());
                if (amount > max) {
                    max = amount;
                    univName = name;

                }

            }
            sb.append(univName.concat("\n"));
        }
        sb.setLength(sb.length() - 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }



}
