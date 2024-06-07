import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int NINE_DWARF= 9;
    static int SEVEN_DWARF= 7;
    static int TOTAL_SUM_HEIGHT = 100;

    static void reduceDwarf(int[] dwarfArr, int sum){
        for (int i = 0; i < NINE_DWARF; i++) {
            for (int j=1; j<dwarfArr.length; j++) {
                if(dwarfArr[i] + dwarfArr[j] == sum - TOTAL_SUM_HEIGHT){
                    dwarfArr[i] = 0;
                    dwarfArr[j] = 0;
                    return ;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int dwarfNum = NINE_DWARF;

        int[] dwarfArr = new int[dwarfNum];
        int sum = 0;

        for (int i = 0; i < NINE_DWARF; i++) {
            int height = Integer.parseInt(br.readLine());  // 버퍼에서 난쟁이 한명의 키를 가져옴
            sum += height;                                  // 난쟁이 9명의 총 키의 합을 구함
            dwarfArr[i] = height; // 난쟁이 각 인원의 키를 배열에 할당.
        }

        reduceDwarf(dwarfArr, sum);
        Arrays.sort(dwarfArr);
        for(int i = 0; i < dwarfArr.length; i++){
            if(dwarfArr[i] != 0){
                System.out.println(dwarfArr[i]);
            }
        }

        bw.close();
        br.close();

    }
}
