class Solution {
    public int[] findBuildings(int[] heights) {
        // modified stack approach
        Stack<int[]> stack = new Stack<>();
        int n  = heights.length;

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty() || stack.peek()[1]<heights[i]){
                stack.push(new int[]{i,heights[i]});
            }
        }

        int len = stack.size();
        int[] res = new int[len];


        for(int i=0;i<len;i++) res[i]=stack.pop()[0];


        return res;
    }
}