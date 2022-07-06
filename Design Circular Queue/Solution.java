class MyCircularQueue {

    int[] queue;
    int front, rear, length;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front=-1;
        rear=-1;
        length=0;
    }
    
    public boolean enQueue(int value) {
        
        if(!isFull()) {

            if(front==-1) {
                queue[0] = value;
                front++; rear++;
            } else {
                if(rear<queue.length-1) {
                    rear++;
                    queue[rear] = value;
                } else {
                    rear = rear/queue.length;
                    queue[rear] = value;
                }
            }

            length++;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean deQueue() {
        
        if(!isEmpty()) {

            if(front==rear){
                front=-1; rear=-1;
            } else {
                if(front<queue.length-1) {
                    front++;
                } else {
                    front = front/queue.length;
                }
            }

            length--;
            return true;
        } else {
            return false;
        }
    }
    
    public int Front() {
        return front==-1 ? -1 : queue[front];
    }
    
    public int Rear() {
        return rear==-1 ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return length==0;
    }
    
    public boolean isFull() {
        return length == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */