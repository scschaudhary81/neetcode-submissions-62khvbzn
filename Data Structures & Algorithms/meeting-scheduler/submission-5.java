class Solution {
    // move the slot which is lacking
    // check the end limit to determine it
    // use two pointer
    public List<Integer> minAvailableDuration(int[][] slot1, int[][] slot2, int duration) {
        Arrays.sort(slot1,(a,b)->a[0]-b[0]);
        Arrays.sort(slot2,(a,b)->a[0]-b[0]);
        List<Integer> common = new ArrayList<>();
        int one = 0;
        int two = 0;
        while(one<slot1.length && two<slot2.length){
            int lb=Math.max(slot1[one][0],slot2[two][0]);
            int ub=Math.min(slot1[one][1],slot2[two][1]);
            int available = ub-lb;
            if(available>=duration){
                common.add(lb);
                common.add(lb+duration);
                break;
            }else{
                if(slot2[two][1]>=slot1[one][1]) one++;
                else two++;
            }
        }

        return common;
    }
}
