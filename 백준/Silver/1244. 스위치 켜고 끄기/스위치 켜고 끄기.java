import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static String solution(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 스위치 배열 개수
        int switchCount = Integer.parseInt(st.nextToken());

        // 스위치 배열
        String[] switchStatusStrArr = br.readLine().toString().split(" ");
        int[] switchStatusIntArray = new int[switchCount];
        for(int i = 0; i < switchCount; i++){
            switchStatusIntArray[i] = Integer.parseInt(switchStatusStrArr[i]);
        }

        // 학생수
        int studentNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < studentNum; i++){
            StringTokenizer tmpSt = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(tmpSt.nextToken());
            int switchNum = Integer.parseInt(tmpSt.nextToken());

            // 남성인 경우
            if(gender == 1){
                for(int j = switchNum-1; j < switchCount; j++){
                    int tmpSwitchNum =  j+1;
                    if((tmpSwitchNum % switchNum) == 0){ // 배수인 경우 스위치를 변경함
                        switchStatusIntArray[j] = switchStatusIntArray[j] != 1 ? 1: 0;
                    }

                }
            // 여성인 경우
            }else{
                int index = switchNum - 1;
                switchStatusIntArray[index] =switchStatusIntArray[index] == 1 ? 0 : 1;
                int left = index - 1;
                int right = index + 1;
                
                while(left >= 0 && right < switchCount && switchStatusIntArray[left] == switchStatusIntArray[right]){
                    switchStatusIntArray[left] = switchStatusIntArray[left]==1 ? 0: 1;
                    switchStatusIntArray[right] = switchStatusIntArray[right]==1 ? 0: 1;
                    left--;
                    right++;
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < switchCount; i++){
            sb.append(switchStatusIntArray[i]).append(" ");
            if ((i + 1) % 20 == 0) sb.append("\n"); // 20개씩 줄바꿈
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = solution(br);
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }

}
