class Solution {
    public int quad(int x,int a,int b,int c){
        return a*x*x+b*x+c;
    }
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int start = 0;
        int end = nums.length-1; 
        ArrayList<Integer> list = new ArrayList<>();


        while(start<=end){
            int startVal = quad(nums[start],a,b,c);
            int endVal = quad(nums[end],a,b,c);
            // if upwards parabola (higher x higher y)
            if(a>=0){
                if(startVal >= endVal){
                    list.add(startVal);
                    start++;
                }else{
                    list.add(endVal);
                    end--;
                }
            }
            // if downward parabola (higher x lower y)
            if(a<0){
                if(startVal <= endVal){
                    list.add(startVal);
                    start++;
                }else{
                    list.add(endVal);
                    end--;
                }
            }
        }
        System.out.println(list);
        return a>=0 
        ?
        IntStream
        .range(0,list.size())
        .map(i->list.get(list.size()-1-i))
        .toArray()
        :
        list
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
    }
}
