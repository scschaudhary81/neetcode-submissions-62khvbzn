class Solution {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details).filter(detail -> {
            int first = detail.charAt(11) - '0';
            int second = detail.charAt(12) - '0';
            int age  = first * 10 + second; 
            return age > 60;
        }).count();
    }
}