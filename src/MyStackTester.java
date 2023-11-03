public class MyStackTester
{
    public static void main(String[] args)
    {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.push(5);
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(9);
        System.out.println(stack.size());
    }
}