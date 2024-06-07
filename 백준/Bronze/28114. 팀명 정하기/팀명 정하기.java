
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] person1 = br.readLine().split(" ");
        String[] person2 = br.readLine().split(" ");;
        String[] person3 = br.readLine().split(" ");;

        int p1 = Integer.parseInt(person1[0]);
        int p2 = Integer.parseInt(person2[0]);
        int p3 = Integer.parseInt(person3[0]);

        int y1 = Integer.parseInt(person1[1]);;
        int y2 = Integer.parseInt(person2[1]);;
        int y3 = Integer.parseInt(person3[1]);;

        String s1 = person1[2];
        String s2 = person2[2];
        String s3 = person3[2];

        int[][] scoreArr = new int[3][2];
        scoreArr[0][0] = 0;
        scoreArr[0][1] = p1;
        scoreArr[1][0] = 1;
        scoreArr[1][1] = p2;
        scoreArr[2][0] = 2;
        scoreArr[2][1] = p3;


        int[] yearArr = new int[]{y1, y2, y3};
        String[] surArr = new String[]{s1, s2, s3};


        Arrays.sort(yearArr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < yearArr.length; i++) {
             String subStrYear = String.valueOf(yearArr[i]).substring(2);
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

        for(int i = 0; i < scoreArr.length; i++) {
            int idx = scoreArr[i][0];
            String subStrSur = String.valueOf(surArr[idx].charAt(0));
            sb2.append(subStrSur);
        }
        System.out.println(sb2.toString());
        br.close();

    }


}
