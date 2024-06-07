import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] persons = new String[3][3];

        for (int i = 0; i < 3; i++) {
            persons[i] = br.readLine().split(" ");
        }

        int[][] scoreArr = new int[3][2];
        int[] yearArr = new int[3];
        String[] surArr = new String[3];

        for (int i = 0; i < 3; i++) {
            scoreArr[i][0] = i;
            scoreArr[i][1] = Integer.parseInt(persons[i][0]);
            yearArr[i] = Integer.parseInt(persons[i][1]);
            surArr[i] = persons[i][2];
        }

        Arrays.sort(yearArr);
        StringBuilder sb = new StringBuilder();
        for (int year : yearArr) {
            String subStrYear = String.valueOf(year).substring(2);
            sb.append(subStrYear);
        }
        System.out.println(sb.toString());

        StringBuilder sb2 = new StringBuilder();
        Arrays.sort(scoreArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]); // Descending order by year
            }
        });

        for (int i = 0; i < scoreArr.length; i++) {
            int idx = scoreArr[i][0];
            String subStrSur = String.valueOf(surArr[idx].charAt(0));
            sb2.append(subStrSur);
        }
        System.out.println(sb2.toString());
        br.close();
    }
}
