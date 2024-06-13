import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();    // n의 값 입력 받기 
    sc.close();
    
      long count = calculateCombination(n, 5);    // 조합 계산 (Calculate combination)
    System.out.println(count);

  }

// nCr 계산 메서드 (nCr calculation method)
public static long calculateCombination(int n, int r) {

  // 결과 변수 초기화 (Initialize result variable)
  long result = 1;

  // nCr 공식: nCr = n! / ((n - r)! * r!)
  // 위 공식을 두 개의 for 루프로 분해하여 계산 (Calculate the formula using two for loops)

  // 1. 분자 계산 (Calculate numerator)
  for (int i = 0; i < r; i++) {
    // 루프 변수 i는 0부터 r-1까지 증가하며,
    // 각 반복마다 n - i를 result에 곱합니다.
    // 이는 n!, (n-1)!, (n-2)! ... (n-r+1)!를 계산하는 것과 동일합니다.
    result *= n - i;
  }

  // 2. 분모 계산 (Calculate denominator)
  for (int i = 1; i <= r; i++) {
    // 루프 변수 i는 1부터 r까지 증가하며,
    // 각 반복마다 result를 i로 나눕니다.
    // 이는 r!를 계산하는 것과 동일합니다.
    result /= i;
  }

  // nCr 값 반환 (Return nCr value)
  return result;
}
}
