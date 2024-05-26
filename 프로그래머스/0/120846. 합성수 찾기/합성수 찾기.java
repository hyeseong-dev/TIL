class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 4; i <= n; i++) { // 4부터 시작하는 이유는 1, 2, 3은 소수이므로 제외
            if (isComposite(i)) {
                count++;
            }
        }
        return count;
    }

    // 주어진 수가 합성수인지를 판별하는 메서드
    private boolean isComposite(int num) {
        int divisors = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                divisors++;
                // 약수의 개수가 3개 이상인 경우 합성수이므로 바로 반환
                if (divisors >= 3) {
                    return true;
                }
                // 약수의 개수가 2개인 경우 소수이므로 판별 종료
                if (i != num / i) {
                    divisors++;
                }
            }
        }
        return false;
    }
}