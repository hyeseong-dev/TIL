
import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int peopleNums = Integer.parseInt(br.readLine());
            int[] sizeNums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] tshirtsPenNums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int tshirtPair = tshirtsPenNums[0];
            int penPair = tshirtsPenNums[1];

            int tshirtsResult = 0;

            // 티셔츠의 묶음 수를 구하기
            for (int tshirtNum : sizeNums) {
                tshirtsResult += (int) Math.ceil((double) tshirtNum / tshirtPair);
            }

            // 펜의 묶음 수 구하기
            int penBundles = peopleNums / penPair;
            int penRemainder = peopleNums % penPair;

            System.out.println(tshirtsResult);
            System.out.println(penBundles + " " + penRemainder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
