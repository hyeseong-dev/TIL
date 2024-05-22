class Solution {
    public int solution(int[] arr1, int[] arr2) {
        // 배열의 길이 비교
        if (arr1.length > arr2.length) {
            return 1;
        } else if (arr1.length < arr2.length) {
            return -1;
        } else {
            // 배열의 길이가 같은 경우 원소의 합을 계산하여 비교
            int sum1 = 0, sum2 = 0;
            for (int num : arr1) {
                sum1 += num;
            }
            for (int num : arr2) {
                sum2 += num;
            }
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}