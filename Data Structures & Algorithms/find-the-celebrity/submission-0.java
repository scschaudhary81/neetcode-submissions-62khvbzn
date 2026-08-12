/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];

        for(int from=0;from < n ; from++){
            for(int to = 0;to < n ; to++){
                if(from == to) continue;
                if(knows(from,to)){
                    inDegree[to]++;
                    outDegree[from]++;
                }
            }
        }
        int index = -1;
        for(int i=0;i<n;i++){
            if(inDegree[i] == n-1 && outDegree[i] == 0){
                index=i;
                break;
            }
        }
        return index;
    }
}
