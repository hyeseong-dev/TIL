

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());

        int cycle = lines+1;
        while(cycle-->0){
            String answer = String.format("%" + lines+"s", "*".repeat(cycle));
            if(cycle==1){
                System.out.print(answer);
            }else{
                System.out.println(answer);
            }
        }
        br.close();
    }
}
