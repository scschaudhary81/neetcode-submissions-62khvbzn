/*
1. Sliding window approach to check the longest valid window
2. Check with two styles in which
    -> even is greater than next
    -> odd is greater than next
*/
class Solution {
    boolean isValid(int i,int[] nums,boolean isEvenGreater){
        return isEvenGreater
            ? i%2 == 0 ? nums[i] > nums[i+1] : nums[i] < nums[i+1]
            : i%2 == 0 ? nums[i] < nums[i+1] : nums[i] > nums[i+1];
    }
    public int longestWindow(int[] arr,boolean isEvenGreater){
        int start = 0;
        int end = 0;
        int len = 1;
        while(end<arr.length){
            len = Math.max(len,end-start+1);
            if(end == arr.length-1 || isValid(end,arr,isEvenGreater)){
                end++;
            }else{
                end++;
                start=end;
            }
        }
        return len;
    }
    public int maxTurbulenceSize(int[] arr) {
        int evenGreater = longestWindow(arr,true);
        int oddGreater = longestWindow(arr,false);
        return Math.max(evenGreater,oddGreater);
    }
}