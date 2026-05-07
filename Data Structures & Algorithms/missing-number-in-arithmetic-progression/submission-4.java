// Idea is to first find d 
// find the right most element till which the AP is correct
// the next element to this will be missing
// if the current mid if correct value move to right to find right most correct value
// if value if incorrect for mid then move to left to find right most correct value

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int find = arr[0];
        int d = (arr[n-1]-arr[0])/n;

        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = (start+end)/2;
            int actualMid = arr[mid];
            int expectedMid = arr[0] + d * mid;
            if(actualMid == expectedMid){
                find = actualMid;
                start = mid+1;
            }else{
                end=mid-1;
            }
        }

        return find+d;
    }
}
