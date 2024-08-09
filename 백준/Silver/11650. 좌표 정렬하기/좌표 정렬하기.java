import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());
            List<int[]> locations = new ArrayList<>();

            for(int i = 0; i < N; i++){
                int[] intArr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                locations.add(intArr);
            }

            // 전체 리스트를 정렬: x 좌표를 우선으로, x가 같으면 y좌표를 기준으로 정렬
            Collections.sort(locations, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] == b[0]){
                        return Integer.compare(a[1], b[1]);
                    }else{
                        return Integer.compare(a[0], b[0]);
                    }
                }
            });

            // 정렬된 결과를 출력
            for(int[] loc: locations){
                System.out.println(loc[0] + " " + loc[1]);
            }
        }
    }
}
