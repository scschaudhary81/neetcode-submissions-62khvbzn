// Basic idea is to take to minimum sticks and merge them
class Solution {
    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
        for(int stick : sticks) minHeap.add(stick);

        while(minHeap.size()>1){
            int firstStick = minHeap.poll();
            int secondStick = minHeap.poll();
            int newStick = firstStick + secondStick;
            minHeap.offer(newStick);
            cost+=newStick;
        }
        return cost;
    }
}
