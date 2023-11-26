import java.util.NoSuchElementException;

protected class LinkedNode<T>
{
    LinkedNode<T> next;
    T data;

    public LinkedNode(T val)
    {
        next = null;
        data = val;
    }

    public LinkedNode next()
    {
        return next;
    }

    public void setNext(LinkedNode nextNode)
    {
        next = nextNode;
    }

    public T getData()
    {
        return data;
    }
}

/**
 * An parameterized interface for the Queue Abstract Data Type
 *
 * @author Benjamin Kuperman (Spring 2005, Spring 2012, Spring 2014)
 */

public class MyQueue<T> implements QueueADT<T>
{
    private LinkedNode<T> head, tail;
    private int length;

    /**
     * Add an item to the queue
     * @param item the data item to add (of type T)
     */
    void enqueue(T item)
    {
        LinkedNode<T> node = new LinkedNode<T>(item);
        if(isEmpty())
        {
            head = node;
        }
        else
        {
            tail.setNext(node);
        }
        length++
    }

    /**
     * Remove the front item from the queue
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T dequeue() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw NoSuchElementException("EMPTY QUEUE - cannot call dequeue on an empty queue");
        }

        T value = head.getData();
        length--;
        head = head.next();

        if(isEmpty())
        {
            tail = null;
        }

        return value;
    }

    /**
     * Return the front item in the queue without removing it
     * @return the front item in the queue
     * @throws NoSuchElementException if the queue is empty
     */
    T front() throws NoSuchElementException
    {
        if(isEmpty())
        {
            throw NoSuchElementException("Queue is empty.");
        }

        return head.getData();
    }

    /**
     * Find how many items are in the queue
     * @return the number of items in the queue
     */
    int size()
    {
        return length;
    }

    /**
     * Determine if the queue is empty
     * @return true if the size is 0, false otherwise
     */
    boolean isEmpty()
    {
        return(size() == 0);
    }

    /**
     * Clear out the data structure
     */
    void clear()
    {
        head = null;
        tail = null;
        length = 0;
    }

}
