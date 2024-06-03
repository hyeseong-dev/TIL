  

    import java.io.*;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N; // 입력 첫째줄에 주어진 Digit
            int widthCount = 0;  // 출력 시, 가로로 누울 수 있는 숫자
            int heightCount = 0; // 출력 시, 세로로 ""   ""    ""

            N = Integer.parseInt(br.readLine());

            char[][] matrix = new char[N][N]; // 가로, 세로 N크기만큼의 정사각형 초기화

            // 이차원 char 배열의 내부 값을 `.` 버퍼에서 가져온 '.' 또는 'X' 중에 하나로 할당함.
            for (int height = 0; height < N; height++) {
                String rowStr = br.readLine();
                for (int width = 0; width < N; width++) {
                    matrix[height][width] = rowStr.charAt(width);
                }
            }

            // 가로 누울 수 있는 경우 카운트, 최소 'XX'부터 1개로 카운트. 'XXX'도 동일하게 1개
            //   1) '..XXX'로 구분하는 경우는 해당 라인의 마지막일 떄
            //   2) 'XXX.'과 같이 바로 다음에 '.'이 오게 될 때 이다.
            //      2.1) '.'을 만나게 되면 -> buffer에 데이터가 있는지 확인
            //          2.1.1) 버퍼에 데이터가 없다면, 다음 loop로 넘어간다.
            //          2.1.2) 버퍼에 데이터가 있고 -> 크기가 2이상인 경우 -> count++하고 버퍼를 비운다.
            //      2.2) 'X'을 만나게 되면 -> buffer에 데이터를 추가한다.
            //   3) 한 줄(너비, 높이) 순회를 마치게 되면 버퍼에 데이터가 있는지 확인하고 2개 이상이면 -> count++한다.

            StringBuilder sbWidth = new StringBuilder();
            StringBuilder sbHeight = new StringBuilder();

            for(int width = 0; width < N; width++) {
                for(int height = 0; height < N; height++) {

                    char withUnitData = matrix[width][height];

                    /**
                     * (0,0)  (0,1)  (0,2)  (0,3)
                     * (1,0)  (1,1)  (1,2)  (1,3)
                     * (2,0)  (2,1)  (2,2)  (2,3)
                     * (3,0)  (3,1)  (3,2)  (3,3)
                     * (4,0)  (4,1)  (4,2)  (4,3)
                     */
                    char heightUnitData = matrix[height][width];

                    //버퍼에 데이터가 없다면, 다음 loop로 넘어간다.
                    if (withUnitData == 'X'&& sbWidth.length() >= 2){
                        widthCount++;
                        sbWidth.setLength(0);

                    }else if(withUnitData == 'X' && sbWidth.length() > 0 ) {
                        sbWidth.setLength(0);

                    }else if(withUnitData == '.'){
                        sbWidth.append(withUnitData);
                    }

                    if (heightUnitData == 'X' && sbHeight.length() >= 2){
                        heightCount++;
                        sbHeight.setLength(0);

                    }else if(heightUnitData == 'X' && sbHeight.length() > 0 ) {
                        sbHeight.setLength(0);

                    }else if(heightUnitData == '.'){
                        sbHeight.append(heightUnitData);
                    }

                }

                // 너비 라인 한 loop를 종료하고 sbWidth에 'X'가 2개 이상으로 있는지 확인하며
                // 있다면 widhCount를 1증가 시킴
                if(sbWidth.length() > 1){
                    widthCount++;
                }
                if(sbHeight.length() > 1){
                    heightCount++;
                }
                // 너비라인 loop 한 사이클이 종료 되었다면 다음에 사용 할 변수 sbWidth를 초기화.
                sbWidth.setLength(0);
                sbHeight.setLength(0);

            }
            bw.write(String.valueOf(widthCount).concat(" ").concat(String.valueOf(heightCount)));
            bw.flush();
            bw.close();
            br.close();
        }
    }







