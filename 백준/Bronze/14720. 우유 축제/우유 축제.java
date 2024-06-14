import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 우유 가게의 수 N 입력
        int N = scanner.nextInt();
        
        // 우유 가게 정보 입력
        int[] milkStores = new int[N];
        for (int i = 0; i < N; i++) {
            milkStores[i] = scanner.nextInt();
        }
        
        // 현재 영학이가 마셔야 할 우유의 종류 (0: 딸기, 1: 초코, 2: 바나나)
        int currentMilk = 0;
        int count = 0;
        
        // 우유 가게들을 순회하며 영학이가 마실 수 있는 우유의 최대 개수를 계산
        for (int i = 0; i < N; i++) {
            if (milkStores[i] == currentMilk) {
                count++;
                currentMilk = (currentMilk + 1) % 3;
            }
        }
        
        // 결과 출력
        System.out.println(count);
        
        scanner.close();
    }
}
