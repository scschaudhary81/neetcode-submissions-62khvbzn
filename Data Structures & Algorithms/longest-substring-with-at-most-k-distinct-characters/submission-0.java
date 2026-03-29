class Solution {
    boolean isValid(HashMap<Character,Integer> memory,int k){
        int count = 0;
        for(Map.Entry<Character,Integer> entry:memory.entrySet()){
            if(entry.getValue()>0) count++;
        }

        return count<=k;
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max_len = 0;
        int start = 0;
        int end = 0;
        int n = s.length();
        HashMap<Character,Integer> memory = new HashMap<>();
        

        while(end<n){
            char current = s.charAt(end);
            memory.put(current,memory.getOrDefault(current,0)+1);
            while(!isValid(memory,k)){
                memory.put(s.charAt(start),memory.get(s.charAt(start))-1);
                start++;
            }
            int len = end-start+1;
            max_len = Math.max(len,max_len);
            end++;
        }

        return max_len;
    }
}
