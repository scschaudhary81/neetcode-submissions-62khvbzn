/**
Consider numbers intailly from 1..n 
For consecuitve Ds we need to reverse the order ? how can we do that?
stack ?
*/

class Solution {
    public int[] findPermutation(String s) {
        int n = s.length()+1;
        int index = 0;
        int[] perm = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int current = 2;
        for(char c : s.toCharArray()){
            if(c=='I'){
                while(!stack.isEmpty()) perm[index++] = stack.pop();
            }
            stack.push(current);
            current++;
        }
        while(!stack.isEmpty()) perm[index++] = stack.pop();
        return perm;
    }
}
