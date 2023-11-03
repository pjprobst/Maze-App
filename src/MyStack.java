import java.util.NoSuchElementException;

public class MyStack implements StackADT
{
    private Node first;
    private int size;
    public MyStack()
    {
        first = null;
        size = 0;
    }

    public void push(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        this.first = newNode;
        size++;
    }

    public Object pop()
    {
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }
        Object element = this.first.data;
        this.first = this.first.next;
        size--;
        return element;
    }

    public void clear()
    {
        while (!(this.first == null))
            pop();
    }

    public int size()
    {
        return size;
    }

    public Object top()
    {
        return this.first.data;
    }

    public boolean isEmpty() 
    {
        return this.first == null;
    }

    static class Node
    {
        public Object data;
        public Node next;
    }
}