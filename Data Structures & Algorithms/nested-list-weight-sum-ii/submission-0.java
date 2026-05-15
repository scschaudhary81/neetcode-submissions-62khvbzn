/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Solution {
    public int calSum(List<NestedInteger> list,int currentDept,int maxDept){
        int currentWeight = maxDept - currentDept + 1;
        int currentSum = 0;
        for(NestedInteger current : list){
            if(current.isInteger()){
                currentSum+=(current.getInteger()*currentWeight);
            }else{
                currentSum+=calSum(current.getList(),currentDept+1,maxDept);
            }
        }
        return currentSum;
    }
    public int calculateMaxDept(int previousDept,List<NestedInteger> list){
        int currentDept = previousDept+1;
        int maxDept = currentDept;
        for(NestedInteger next : list){
            if(!next.isInteger()){
                int nextDept = calculateMaxDept(currentDept,next.getList());
                maxDept = Math.max(maxDept,nextDept);
            }
        }
        return maxDept;
    }
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDept = calculateMaxDept(0,nestedList);

        return calSum(nestedList,1,maxDept);
    }
}
