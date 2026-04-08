class Solution {
    public int quad(int x,int a,int b,int c){
        return a*x*x+b*x+c;
    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        return Arrays
        .stream(nums)
        .boxed()
        .map(num->quad(num,a,b,c))
        .sorted()
        .mapToInt(Integer::intValue)
        .toArray();
    }
}
