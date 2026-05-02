class Solution {
    public String rearrangeString(String s, int k) {
        // output
        StringBuilder output = new StringBuilder();
        // count frequecy
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c%97]++;
        // max heap of frequency of characters
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i = 0;i < count.length;i++){
            if(count[i] == 0) continue;
            maxHeap.offer(new int[]{i,count[i],0});
        }
        // min heap of frequency of characters with time
        PriorityQueue<int[]> waitHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);

        int time = 0;
        while(!maxHeap.isEmpty() || !waitHeap.isEmpty()){
            // add back the characters available to be added
            while(!waitHeap.isEmpty() && waitHeap.peek()[2] <= time){
                maxHeap.add(waitHeap.poll());
            }
            // check if maxHeap is not empty
            if(maxHeap.size() == 0) return "";
            // process current entry
            int[] current = maxHeap.poll();
            char c = (char)('a' + current[0]);
            current[1]-=1; // decrease the frequency
            current[2]=time+k; // new available time

            if(current[1] > 0) waitHeap.offer(current); // add in waiting queue
            output.append(c); // append output

            time++; // move to next time
        }


        return output.toString();
    }
}
