class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int len = 0;
        int start = 0;
        int end = 0;
        int count = 1;

        while(end<n){
            if(nums[end]==0){
                if(count==0){
                    while(count==0){
                        if(nums[start]==0) count++;
                        start++;
                    }
                }else count--;
            }

            int c_len = end-start+1;
            len = Math.max(len,c_len);
            end++;
        }

        return len;
        
    }
}
