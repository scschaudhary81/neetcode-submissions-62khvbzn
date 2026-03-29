class Solution {
    public int maxArea(int[] heights) {
        int a = 0;
        int b = heights.length-1;
        int max = Integer.MIN_VALUE;
        while(a<b){
            int value = Math.min(heights[a],heights[b])*(b-a);
            if(heights[a]<heights[b]) a++;
            else b--;
            max = Math.max(max,value);
        }



        return max;
    }
}
