import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.nextLine();
        int count = 0;
        Set<String> alphabetSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subStr = str.substring(i, j);
                alphabetSet.add(subStr);
            }
        }
        System.out.println(alphabetSet.size());
    }
}
