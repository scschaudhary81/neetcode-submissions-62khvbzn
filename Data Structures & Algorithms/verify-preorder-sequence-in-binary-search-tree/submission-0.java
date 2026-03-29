class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int min_value = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        boolean isPossible = true;
        for(int num : preorder){
            if(num<min_value){
                isPossible = false;
                break;
            }
            while(!stack.empty() && stack.peek()<num){
                min_value = stack.pop();
            }
            stack.push(num);
        }
        return isPossible;
    }
}
