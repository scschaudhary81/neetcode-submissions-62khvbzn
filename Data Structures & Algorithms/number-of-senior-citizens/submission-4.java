class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String detail : details){
            int first = detail.charAt(11) - '0';
            int second = detail.charAt(12) - '0';
            int age  = first * 10 + second; 
            if(age > 60){
                count++;
            }
        }
        return count;
    }
}