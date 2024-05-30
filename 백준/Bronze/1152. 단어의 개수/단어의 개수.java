import java.util.Scanner;

public class Main {
    public static int solution(String strList) {
        int count = 0;
        for (String str : strList.split(" ")) {
            if (!str.isEmpty()) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        
        System.out.println(solution(s));
        
        scanner.close();
    }
}
