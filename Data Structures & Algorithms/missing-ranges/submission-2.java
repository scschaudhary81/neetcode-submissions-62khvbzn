class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> list = new ArrayList<>();
        int start = lower;
        for(int num:nums){
            int end = num-1;
            if(start<=end) list.add(List.of(start,end));
            start = num+1;
        }
        if(start<=upper) list.add(List.of(start,upper));
        return list;
    }
}
