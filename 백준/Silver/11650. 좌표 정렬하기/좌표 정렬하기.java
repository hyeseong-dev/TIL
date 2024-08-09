import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int N = Integer.parseInt(br.readLine());

            HashMap<Integer, List<Integer>> locationMap = new HashMap<>();

            for(int i = 0; i < N; i++){
                int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int x = intArr[0];
                int y = intArr[1];

                List<Integer> xLocation = locationMap.get(x);
                if(xLocation == null){
                    xLocation = new ArrayList<>();
                    locationMap.put(x, xLocation);
                }
                xLocation.add(y);
            }

            List<Integer> xLocationList = new ArrayList<>(locationMap.keySet());
            Collections.sort(xLocationList);

            for(int x: xLocationList){
                List<Integer> yLocations = locationMap.get(x);
                Collections.sort(yLocations);
                for(int y : yLocations){
                    System.out.println(x + " " + y);
                }
            }
        }
    }
}
