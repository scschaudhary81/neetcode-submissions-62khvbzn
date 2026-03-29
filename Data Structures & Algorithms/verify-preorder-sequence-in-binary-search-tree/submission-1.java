/*
[5,2,1,3,6]
Sort of montonic decreasing stack
as root -> left -> left will always be decreasing
1. Preorder traversal is Root left right
2. So as soon as i encounter an greater element from previous element i have moved to right subtree
3. Now pop till stack till  top element is less than current element
4. This is the root element now and also all the nums going forward > root

*/
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
