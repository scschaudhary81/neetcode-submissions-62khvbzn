/*
1. Parse from left to right
2. If : add value
3. If encounter ? pop 2 previous values and check if index-1 char and decide which one two pick, push it back to stack
*/
class Solution {
    public String parseTernary(String a) {
        Stack<String> stack = new Stack<>();
        String current = "";

        int index = a.length()-1;
        while(index>=0){
            char c = a.charAt(index--);
            if(c==':'){
                if(!current.isEmpty()){
                    stack.push(current);
                    current = "";
                }
            }else if(c=='?'){
                if(!current.isEmpty()){
                    stack.push(current);
                    current = "";
                }
                String one = stack.pop();
                String two = stack.pop();
                stack.push(a.charAt(index--) == 'T' ? one : two);
            }else{
                current+=c;
            }
        }

        return stack.pop();
    }
}
