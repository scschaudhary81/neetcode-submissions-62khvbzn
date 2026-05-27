class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;
        int prevMin = Integer.MAX_VALUE;
        int prevMax = Integer.MIN_VALUE;
        for(List<Integer> array : arrays){
            int currentMin = array.get(0);
            int currentMax = array.get(array.size()-1);
            if(prevMin!=Integer.MAX_VALUE){
                int currentMaxDiff = Math.max(Math.abs(currentMin-prevMax),Math.abs(currentMax-prevMin));
                maxDistance = Math.max(maxDistance,currentMaxDiff);
            }
            prevMin = Math.min(prevMin,currentMin);
            prevMax = Math.max(prevMax,currentMax);
        }
        return maxDistance;
    }
}
