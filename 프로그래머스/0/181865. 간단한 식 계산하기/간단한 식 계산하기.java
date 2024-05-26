class Solution {
    public Long solution(String binomial) {
        Long answer = 0L;

        if(binomial.contains("+")){
            String[] strNums = binomial.split("\\+");
            Long front = Long.valueOf(strNums[0].trim());
            Long back = Long.valueOf(strNums[1].trim());
            return front + back;

        }else if(binomial.contains("-")){

            String[] strNums = binomial.split("-");
            Long front = Long.valueOf(strNums[0].trim());
            Long back = Long.valueOf(strNums[1].trim());
            return front - back;

        }else if(binomial.contains("*")){
            String[] strNums = binomial.split("\\*");
            Long front = Long.valueOf(strNums[0].trim());
            Long back = Long.valueOf(strNums[1].trim());
            return front * back;
        }



        return answer;
    }
}