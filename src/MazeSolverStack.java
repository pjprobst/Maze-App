public class MazeSolverStack extends MazeSolver 
{
    static MyStack<square> worklist;

    public MazeSolverStack(maze maze)
    {
        super(maze);
        makeEmpty();
        maze.getStart().setPrevious(null);
        add(maze.getStart());
    }
    
    public void makeEmpty()
    {
       worklist = new MyStack<>();
    }

    public boolean isEmpty()
    {
        return worklist.isEmpty();
    }

    public void add(square sq)
    {
        worklist.push(sq);
    }
    public square next()
    {
        return ((square) worklist.pop());
    }

    public square top()
    {
        return ((square) worklist.top());
    }

    public Object getWorklist()
    {
        return worklist;
    }

}