public class MyQueueTest{

    public static void main(String[] args){
        MyQueue<int> test = new MyQueue<int>();
        
        System.out.println("Size must be 0\tsize: " + test.size());
        System.out.println("Queue must be empty\tisEmpty: " + test.isEmpty());
        test.enqueue(10);
        test.enqueue(20);
        test.enqueue(30);
        System.out.println("Size must be 3\tsize: " + test.size());
        System.out.println("Queue must not be empty\tisEmpty : " + test.isEmpty());
        System.out.println("Front must be 10\tfront value = " + test.front());
        int removedValue = test.dequeue();
        System.out.println("Queue must have removed 30\tremoved item: " + removedValue);
        removedValue = test.dequeue();
        removedValue = test.dequeue();
        System.out.println("Queue must be empty\tisEmpty: " + test.isEmpty());
        try
        {
            removedValue = test.dequeue();
            System.out.println("Should not see this message (can't call dequeue on empty queue)");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("dequeue failed because queue is empty, messsage: " + e.message());
        }
    }        
}
