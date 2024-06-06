import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();

        long hash = 0;
        long r = 31;
        long M = 1234567891;
        long powerOfR = 1;

        for (int i = 0; i < L; i++) {
            int charValue = str.charAt(i) - 'a' + 1;
            hash = (hash + charValue * powerOfR) % M;
            powerOfR = (powerOfR * r) % M;
        }

        System.out.println(hash);
    }
}
