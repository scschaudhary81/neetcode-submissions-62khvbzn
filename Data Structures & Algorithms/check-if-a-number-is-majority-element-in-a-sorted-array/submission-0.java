class Solution {
    int left(int [] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int mid;
        int left_most=-1;

        while(start<=end){
            mid = (start+end)/2;
            if(nums[mid]==target){
                left_most=mid;
                end=mid-1;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return left_most;
    }


    int right(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int mid;
        int right_most=-1;
        while(start<=end){
            mid = (start+end)/2;
            if(nums[mid]==target){
                right_most=mid;
                start=mid+1;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return right_most;
    }


    
    public boolean isMajorityElement(int[] nums, int target) {
        int left_most = left(nums,target);
        int right_most = right(nums,target);
        if(left_most==-1 || right_most==-1) return false;

        int actual = right_most-left_most+1;
        int expected = nums.length/2+1;

        return actual>=expected;
    }
}
