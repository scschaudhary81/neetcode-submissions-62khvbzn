class Solution {
    String result = "";
    public String encode(List<String> strs) {
        strs.forEach(val->{result+=val+"\n";});
        return result; 
    }

    public List<String> decode(String str) {
        String current = "";
        List<String>list = new ArrayList<>();
            for(Character ch:str.toCharArray()){
                if(ch.equals('\n')){
                    list.add(current);
                    current="";
                }else{
                    current+=ch;
                }
            }

            return list;
    }
}
