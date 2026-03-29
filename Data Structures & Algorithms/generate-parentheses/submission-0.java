class Solution {

/* at any place there can be ( or ) but both should be in equal number atlast when both equal to n check by valid paranthesis logic */
boolean isValid(String s){
    Stack<Character> stack = new Stack();
    for(char c : s.toCharArray()){
        if(c=='(') stack.push(c);
        else{
            if(c==')' && !stack.empty() && stack.peek().equals('(')){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
    }
    return stack.empty();
}
    public void traverse(List<String>result,int a,int b,int size,String s){
        if(a== size && b ==  size){
            if(isValid(s)){
                result.add(s);
            }
            return;
        }
        if(a<size)
        traverse(result,a+1,b,size,s+"(");
        if(b<size)
        traverse(result,a,b+1,size,s+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        traverse(result,0,0,n,"");
        return result;
    }
}