import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        // 원점수가 담긴 리스트
        List<Integer> digitList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        // 원점수 리스트 중 최대값
        int max = Collections.max(digitList);

        // 점수 세탁 로직 : (원래최고점수 / 원래점수[idx]) * 100
        List<Double> cleanedNumArr = new ArrayList<>(3);

        for(double num : digitList) {
            double cleanNum = ( num / max ) * 100;
            cleanedNumArr.add(cleanNum);
        }

        double total = cleanedNumArr.stream().mapToDouble(num -> num.doubleValue()).sum();
        double answer = total / n;

        System.out.println(answer);

    }
}
