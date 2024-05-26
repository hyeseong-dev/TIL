class Solution {
    public int[][] solution(int[] num_list, int n) {
        int size = num_list.length/n;
        int[][] answer = new int[size][n];

        int idx = 0;
        for (int i = 0; i < size; i++) {
            for (int z = 0; z < n; z++) {
                answer[i][z] = num_list[idx++];
            }
        }

        return answer;
    }
}