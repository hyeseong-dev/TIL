

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        Set<Integer> soldTicketSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            soldTicketSet.add(Integer.parseInt(st.nextToken()));
        }

        int ticket = 1;
        while (soldTicketSet.contains(ticket)) {
            ticket++;
        }

        bw.write(ticket + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
