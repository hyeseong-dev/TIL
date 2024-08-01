import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String input;
            while ((input = br.readLine()) != null && !input.equals("0")) {
                bw.write(isPalindrome(input) ? "yes" : "no");
                bw.newLine();
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        int halfLength = length / 2;

        for (int i = 0; i < halfLength; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
