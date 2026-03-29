class Solution {
    public int missingElement(int[] nums, int k) {
        int missing  = -1;
        int prev = nums[0]-1;
        for(int num:nums){
            if(num-prev>1){
                for(int i=prev+1;i<num;i++){
                    k--;
                    if(k==0){
                        missing = i;
                        break;
                    }
                
                }
            }
            prev=num;
        }
        while(k>0){
            k--;
            prev++;
            missing = prev;
        }
        return missing;
    }
}
