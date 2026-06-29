class Solution {
    public int maxDifference(String s) {
        int[] memory = new int[26];
        for(char c : s.toCharArray()){
            memory[c-'a']++;
        }
        int odd_max = Integer.MIN_VALUE;
        int odd_min = Integer.MAX_VALUE;
        int even_max = Integer.MIN_VALUE;
        int even_min = Integer.MAX_VALUE;

        for(int  i : memory){
            if( i == 0 ) continue;
            if(i % 2 == 0){
                even_max = Math.max(even_max,i);
                even_min = Math.min(even_min,i);

            }else{
                odd_max = Math.max(odd_max,i);
                odd_min = Math.min(odd_min,i);
            }
        }

        int diff_one = even_max == Integer.MIN_VALUE || odd_min == Integer.MAX_VALUE ? -1 :  odd_min - even_max;
        int diff_two = odd_max == Integer.MIN_VALUE || even_min == Integer.MAX_VALUE ? -1 : odd_max - even_min;
        return Math.max(diff_one,diff_two);
    }
}