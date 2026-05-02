class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b)->{
                if(a[0] == b[0]){
                    if(a[1]==b[1]) return a[2]-b[2];
                    else return a[1]-b[1];
                }else{
                    return a[0] - b[0];
                }
            }
        );

        for(int i=0;i<workers.length;i++){
            for(int j=0;j<bikes.length;j++){
                int d = Math.abs(workers[i][0]-bikes[j][0]) + Math.abs(workers[i][1]-bikes[j][1]);
                minHeap.offer(new int[]{d,i,j});
            }
        }

        int[] result = new int[workers.length];
        Arrays.fill(result,Integer.MAX_VALUE);
        HashSet<Integer> takenBikes = new HashSet<>();

        while(!minHeap.isEmpty() && takenBikes.size() < workers.length){
            int[] current = minHeap.poll();
            int worker = current[1];
            int bike = current[2];
            if(result[worker] == Integer.MAX_VALUE && !takenBikes.contains(bike)){
                result[worker] = bike;
                takenBikes.add(bike);
            }
        }
        return result;
    }
}
