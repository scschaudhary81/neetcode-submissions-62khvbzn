class Solution {
    public int missingElement(int[] nums, int k) {
        for(int i=1;i<nums.length;i++){
            int missing = nums[i]-nums[i-1]-1;
            if(missing >= k) return nums[i-1] + k;
            else k-=missing;
        }
        return nums[nums.length-1]+k;
    }
}
