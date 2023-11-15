import java.util.*;

public abstract class MazeSolver {

    protected static Stack<square> currPath; // THE PATH THE SOLVER TAKES TO THE FINISH
    protected boolean traversed = false; // BECOMES TRUE ONCE THE ENTIRE MAZE HAS BEEN TRAVERSED OR THE FINISH HAS BEEN FOUND
    protected static maze theMaze; // MAZE THAT IS BEING SOLVED
    protected boolean finished = false; // IF THE FINISH HAS BEEN FOUND OR NOT

   public MazeSolver(maze maze)
    {
        theMaze = maze;
    }


    //ABSTRACT METHODS
    abstract void makeEmpty();
    abstract boolean isEmpty();
    abstract void add(square sq);
    abstract square next();
    abstract square top();
    abstract Object getWorklist();


    public boolean isSolved()
    {
        return traversed;
    }

    //RETURNS A STRING WITH THE COORDINATES OF EVERY square ALONG THE PATH
    public String getPath()
    {
        String path = "";
        if (isSolved())
        {
            if (!finished)
                return "This maze is unsolvable.";
            else 
            {
                square backtracked = theMaze.getFinish();
                while (!(backtracked.getRow() == theMaze.getStart().getRow() && backtracked.getCol() == theMaze.getStart().getCol() && backtracked.getType() == theMaze.getStart().getType()))
                {
                    int xcord = backtracked.getRow();
                    int ycord = backtracked.getCol();
                    path = "[" + xcord + "," + ycord + "], " + path;
                    backtracked = backtracked.getPrevious();
                }
            }
        }
        else
            return "This Maze has not been solved yet.";
        
        finished = false;
        traversed = false;
        return path;
    }



    //MOVES FORWARD A square
    public square step()
    {
        boolean found = false;
        if (isEmpty())
        {
            traversed = true;
            finished = false;
            return null;
        }
        else
        {
            square move = next();
            if (move.getType() == 3)
            {
                traversed = true;
                finished = true;
                square backtracked = theMaze.getFinish();
                while (!(backtracked.getRow() == theMaze.getStart().getRow() && backtracked.getCol() == theMaze.getStart().getCol() && backtracked.getType() == theMaze.getStart().getType()))
                {
                    if (backtracked.getType() != 2 && backtracked.getType() != 3)
                        backtracked.setCharType('x');
                    backtracked = backtracked.getPrevious();
                }
            }
            else 
            {
                ArrayList<square> borders = theMaze.getNeighbors(move);
                for (int i = 0; i < borders.size(); i++)
                {
                    if (borders.get(i).getType() != 1 && !(borders.get(i).isExplored()))
                    {
                        found = true;
                        add(borders.get(i));
                        if (borders.get(i).getType() != 2 && borders.get(i).getType() != 3)
                            borders.get(i).setCharType('o');
                        borders.get(i).setPrevious(move);
                        if (move.getType() != 2 && move.getType() != 3)
                            move.setCharType('.');
                    }
                }
                move.setExplored();
                if (!found)
                {
                    if (move.getType() != 2 && move.getType() != 3)
                        move.setCharType('.');
                }
            }
            return move;
        }
    }


    //RUNS UNTIL IS SOLVED BECOMES TRUE
    public void solve()
    {
        while (!isSolved()) 
        {
            step();
        }
    }
}