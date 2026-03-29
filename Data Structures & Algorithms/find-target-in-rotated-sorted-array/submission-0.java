class Solution {
    public int search(int[] nums, int target) {
     int start = 0;
     int end = nums.length-1;
     int index = -1;


     while(start<=end){
        int mid = start +  (end-start)/2;
        if(nums[mid] == target){
            return mid;
        }else if(target > nums[mid]){
                // in left sub array
                if(nums[mid] >= nums[start]){
                start = mid + 1;
                }else{
                // in right sub array
                if(target<=nums[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                    }
                }
        }else{
                // in left sub array
                if(nums[mid] >= nums[start]){
                    if(target<nums[start]){
                        start = mid+1;
                    }else{
                        end = mid-1;
                    }
                }else{
                // in right sub array
                end = mid-1;
                }
        }
     }


     return index;

}
}
