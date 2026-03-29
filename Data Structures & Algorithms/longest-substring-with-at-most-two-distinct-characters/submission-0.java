class Solution {
    public boolean isValid(HashMap<Character,Integer> memory){
        int count = 0;
        for(Map.Entry<Character,Integer> entry:memory.entrySet()){
            if(entry.getValue()>0) count++;
        }
        return count<=2;
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> memory = new HashMap<>();
        int start=0;
        int end=0;
        int n = s.length();
        int max_len = 0;


        while(end<n){
            char current = s.charAt(end);
            memory.put(current,memory.getOrDefault(current,0)+1);
            while(!isValid(memory)){
                memory.put(s.charAt(start),memory.get(s.charAt(start))-1);
                start++;
            }
            int c_len = end-start+1;
            max_len = Math.max(c_len,max_len);
            end++;
        }

        return max_len;
    }
}