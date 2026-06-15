class Solution {
    public long countSubarrays(int[] nums) {
        int start = 0;
        int end = 0;
        long result = 0;

        while(end < nums.length){
            if(end > 0 && nums[end-1] >= nums[end]){
                start = end;
            }

            long endingWith = (end-start+1);
            result+=endingWith;
            end++;
        }

        return result;
    }
}
