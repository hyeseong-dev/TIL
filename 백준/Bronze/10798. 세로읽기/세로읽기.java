
import java.io.*;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException{
//        String input ="ABCDE\n"+
//                      "abcde\n"+
//                      "01234\n"+
//                      "FGHIJ\n"+
//                      "fghij";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new StringReader(input));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<char[]> q = new Queue<>();   // Queue 객체 생성 (char[] 배열을 저장하는 큐)

        // 입력된 각 라인을 읽어 큐에 char[] 배열로 저장
        String line;
        int count = 0; // 입력된 줄 수를 세기 위한 변수

        while (count < 5 && (line = br.readLine()) != null) {
            q.enqueue(line.toCharArray());
            count++;
        }

        // 결과를 저장할 StringBuilder 객체 생성
        StringBuilder sb = new StringBuilder();

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            QNode<char[]> node = q.front;    // 큐의 앞쪽 노드를 가져옴
            char[] charArr = node.data;     // 해당 노드의 데이터를 char[] 배열로 가져옴
            char chr = charArr[0]; // char[] 배열 0 인덱스의 데이터를 변수에 할당
            sb.append(chr);  // 배열의 첫 번째 문자를 StringBuilder에 추가

            // 배열의 길이가 1보다 크면 나머지 배열을 큐에 다시 추가
            if (charArr.length > 1) {

                // idx         0    1    2    3
                // char[]    {'A', 'B', 'C', 'D'}
                // `Arrays.copyOfRange`메소드를 이용하여 배열을 슬라이싱함.
                char[] remainder = Arrays.copyOfRange(charArr, 1, charArr.length);
                q.enqueue(remainder); // 예) `{'B', 'C', 'D'}`를 다시 저장함
            }

            q.dequeue(); // 현재 앞쪽 노드를 큐에서 제거
        }

        System.out.println(sb.toString());

    }

    // 큐에 저장 될  연결 리스트(LL)의 노드
    static class QNode<T> {
        T data;// 데이터를 저장하는 변수
        QNode<T> next; // 다음 노드를 가리키는 포인터

        // 새로운 연결 리스트 노드를 생성하는 생성자
        public QNode(T data){
            this.data = data;
            this.next = null;
        }
    }

    // 큐를 나타내는 클래스
    // front는 LL의 맨 앞 노드를 저장하고, rear는 LL의 마지막 노드를 저장함
    static class Queue<T> {
        QNode<T> front, rear; // front: 큐의 맨 앞 노드, rear: 큐의 맨 뒤 노드

        public Queue(){
            this.front = this.rear = null;
        }

        void enqueue(T data) {

            // 새로운 LL 노드 생성
            QNode<T> temp = new QNode<>(data);

            // 큐가 비어 있는 경우, 새 노드가 front와 rear가 됨
            if (this.rear == null) {
                this.front = this.rear = temp;
                return;
            }

            // 새 노드를 큐 끝에 추가하고 rear를 변경함
            this.rear.next = temp;
            this.rear = temp;
        }

        // queue에서 항목을 제거하는 메서드
        void dequeue(){

            // 큐가 비어있는 경우, 아무 것도 반환하지 않음
            if(this.front == null)
                return;

            // 이전 front를 저장하고 front를 한 노드 앞으로 이동함
            QNode<T> temp = this.front;
            this.front = this.front.next;

            // front가 NULL이 되면, rear도 NULL로 변경함
            if(this.front == null)
                this.rear = null;
        }

        // check the queue is empty or not
        boolean isEmpty(){
            return front == null;
        }

        }
}



