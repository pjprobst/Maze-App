import java.util.*;

public class MazeSolverQueue extends MazeSolver
{
    void makeEmpty() 
    {
        worklist = new MyQueue<square>();
    }

    boolean isEmpty()
    {
        return worklist.isEmpty();
    }

    void add(square sq)
    {
        worklist.enqueue(sq);
    }

    square next()
    {
        return worklist.front();
    }

    private MyQueue<square> worklist;

    public MazeSolver(maze maze)
    {
        super(maze) = maze;
        
        //theMaze.loadMaze("src/maze-1");
        this.makeEmpty();
        this.add(theMaze.getStart());
    }



    public boolean isSolved()
    {
        for (int i = 0; i < worklist.size(); i++)
        {
            if (worklist.get(i).getType() == 3)
                return true;
        }
        if (worklist.isEmpty())
            return true;
        return false;
    }



    public String getPath()
    {
        String path = "";
        if (isSolved())
        {
            if (worklist.isEmpty())
                return "This maze is unsolvable.";
            else 
                for (int i = 0; i < worklist.size(); i++)
                {
                    int xcord = worklist.get(i).getRow();
                    int ycord = worklist.get(i).getCol();
                    path = path + "[" + xcord + "," + ycord + "], ";
                }
        }
        else
            return "This Maze has not been solved yet.";
        
        return path;
    }



    public square step()
    {
        square currsq = worklist.get(0);
        square nextsq = null;
        if (theMaze.getNeighbors(currsq).size() > 0)
        {
            for (int i = 0; i < theMaze.getNeighbors(currsq).size(); i++)
            {
                nextsq = theMaze.getNeighbors(currsq).get(i);
                if (!(nextsq.isExplored()))
                {
                    nextsq.setExplored();
                    this.add(nextsq);
                    return nextsq;
                }
            }
        }
        return null;
    }


    
    public void solve()
    {
        while ((!(worklist.isEmpty())) &&  worklist.get(worklist.size() - 1).getType() != 3)
        {
            step();
        }
    }
}