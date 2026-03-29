class Solution {
    String result = "";
    public String encode(List<String> strs) {
        strs.forEach(val->{result+=val.length()+"#"+val;});
        return result; 
    }

    public List<String> decode(String str) {
        System.out.println(str);
      List<String>list = new ArrayList<>();
      int idx = 0;
      int last = str.length();
      String current = "";
      while(idx<last){
        if(str.charAt(idx)=='#'){
            int len = Integer.valueOf(current);
            list.add(str.substring(idx+1,idx+1+len));
            idx+=len+1;
            current="";
        }else{
            current+=str.charAt(idx);
            idx++;
        }
      }

      return list;
    }
}
