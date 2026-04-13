class DoubleLinkedList{
    DoubleLinkedList prev = null;
    DoubleLinkedList next = null;
    int value = -1;
    int rank = 0;

    DoubleLinkedList(int value,DoubleLinkedList prev,DoubleLinkedList next,int rank){
        this.value = value;
        this.prev = prev;
        this.next = next;
        if(this.prev != null) this.prev.next = this;
        if(this.next != null) this.next.prev = this;
        this.rank = rank;
    }

    void deleteNode(){
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleLinkedList)) return false;
        DoubleLinkedList that = (DoubleLinkedList) o;

        return value == that.value && rank == that.rank;
    }


}

class MaxStack {
    DoubleLinkedList head;
    DoubleLinkedList tail;
    PriorityQueue<DoubleLinkedList> maxHeap;
    HashSet <DoubleLinkedList> deleted = new HashSet<>();
    int current_rank = 0;
    public MaxStack() {
        head = new DoubleLinkedList(-1,null,null,0);
        tail = head;
        maxHeap  = new PriorityQueue<>((a,b)->{
            if(a.value==b.value) return b.rank-a.rank;
            else return b.value-a.value;
        });
    }
    
    public void push(int x) {
        current_rank++;
        DoubleLinkedList current = new DoubleLinkedList(x,tail,null,current_rank);
        tail = current;
        maxHeap.add(current);
        DoubleLinkedList it = head;
    }
    
    public int pop() {
        DoubleLinkedList toRemove = tail;
        tail = tail.prev;
        tail.next = null;
        deleted.add(toRemove);
        return toRemove.value;
    }
    
    public int top() {
        return tail.value;
    }

    public void resetStackIfNodeAlreadyDelete(){
        while(maxHeap.size()>0 && deleted.contains(maxHeap.peek())) maxHeap.poll();
    }
    
    public int peekMax() {
        resetStackIfNodeAlreadyDelete();
        return maxHeap.peek().value;
    }
    
    public int popMax() {
        resetStackIfNodeAlreadyDelete();
        DoubleLinkedList toRemove = maxHeap.poll();
        // handle first and last nodetoRemove.remove();
        if(toRemove.prev == null){
            head = head.next;
            head.prev = null;
        }else if(toRemove.next == null){
            tail = tail.prev;
            tail.next = null;
        }else{
            toRemove.deleteNode();
        }

        return toRemove.value;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
