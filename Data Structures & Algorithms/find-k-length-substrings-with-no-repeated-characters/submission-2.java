/*
Calculate for each ending element
Decrease the window size while its len > k or window contains duplicate elements
*/


class Solution {
    boolean isValid(HashMap<Character,Integer> memory){
        for(Map.Entry<Character,Integer> current: memory.entrySet()){
            if(current.getValue()>1) return false;
        }
        return true;
    }

    public int numKLenSubstrNoRepeats(String s, int k) {
        HashMap<Character,Integer> memory = new HashMap<>();
        int count = 0;
        int start = 0;
        int end = 0;
        int n = s.length();


        while(end<n){
            char current_char = s.charAt(end);
            memory.put(current_char,memory.getOrDefault(current_char,0)+1);
            while(!isValid(memory) || (end-start+1>k)){
                char start_char = s.charAt(start);
                memory.put(start_char,memory.get(start_char)-1);
                start++;
            }
            if(end-start+1==k) count++;
            end++;
        }

        return count;
    }
}
