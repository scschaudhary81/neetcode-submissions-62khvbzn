class Solution {

    public int init(int i,HashMap<Integer,Integer>map){
        Integer value  = map.get(i-1);
        if(value==null) {
            map.put(i,1);
            return 1;
        }else{
            if(value.equals(-1)) {
               value =  init(i-1,map);
            }
            map.put(i,value+1);
            return value+1;
        }
    }
    public int longestConsecutive(int[] nums) {
        int size = 0;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i : nums){
            map.put(i,-1);
        }
        for(int i:nums){
            int value =init(i,map);
            size = Math.max(value,size);
        }
        return size;
    }
}