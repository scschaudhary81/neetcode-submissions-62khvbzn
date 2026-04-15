/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int start = 0;
        int end = reader.length()-1;
        int index = -1;


        while(start<=end){
            boolean isEven = (end-start+1) % 2 == 0;
            int mid = (end+start)/2;
            // if start == end
            if(start==end){
                index=start;
                break;
            }else if(isEven){
                int compare = reader.compareSub(start,mid,mid+1,end);
                if(compare == 1) end = mid;
                if(compare == -1) start = mid + 1;
            }else{
                int compare = reader.compareSub(start,mid-1,mid+1,end);
                if(compare == 1) end = mid-1;
                else if(compare == -1) start = mid + 1;
                else{
                    index = mid;
                    break;
                }
            }
        }   


        return index;
    }
}
