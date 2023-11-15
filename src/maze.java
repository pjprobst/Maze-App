import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class maze
{
    private square[][] maze;
    int numRows, numCols;
    private square start, finish;
    public maze()
    {
        numRows = 0;
        numCols = 0;
    }



    boolean loadMaze(String fname)
    {
        Scanner scan;
        try 
        {
            File textfile = new File(fname);
            scan = new Scanner(textfile);
            
        }
        catch (FileNotFoundException e) 
        {
            return false;
        }
        numRows = scan.nextInt();
        numCols = scan.nextInt();
        maze = new square[numRows][numCols];

        for (int row=0; row < numRows; row++) 
        {
            for (int col=0; col < numCols; col++)
            {
                int currType = scan.nextInt();
                maze[row][col] = new square(row, col, currType);
                if (currType == 2)
                    start = maze[row][col];
                if (currType == 3)
                    finish = maze[row][col];
            }
        }
        scan.close();
        return true;
    }
    
    


    public ArrayList<square> getNeighbors(square sq)
    {
        int currRow = sq.getRow();
        int currCol = sq.getCol();
        ArrayList<square> neighbors = new ArrayList<>();

        if (currRow - 1 >= 0)
        {
            if(maze[currRow - 1][currCol] != null && !(maze[currRow - 1][currCol].isExplored()))
                neighbors.add(maze[currRow - 1][currCol]);
        }
        if (currCol + 1 < numCols)
        {
            if (maze[currRow][currCol + 1] != null && !(maze[currRow][currCol + 1].isExplored()))
                neighbors.add(maze[currRow][currCol + 1]);
        }
        if (currRow + 1 < numRows)
        {
            if(maze[currRow + 1][currCol] != null && !(maze[currRow + 1][currCol].isExplored()))
                neighbors.add(maze[currRow + 1][currCol]);
        }
        if (currCol - 1 >= 0)
        {
            if(maze[currRow][currCol - 1] != null && !(maze[currRow][currCol - 1].isExplored()))
                neighbors.add(maze[currRow][currCol - 1]);
        }
        if (neighbors.isEmpty())
            sq.setCharType('.');
        return neighbors;
    }



    public square getStart()
    {
        return start;
    }

    public square getFinish()
    {
        return finish;
    }



    public void reset()
    {
        for (int i = 0; i < numRows; i++)
        {
            for (int k = 0; k < numCols; k++)
            {
                maze[i][k].reset();
            }
           
        }
    }



    public String toString()
    {
        String mazeString = "";

        for (int i = 0; i < maze.length; i++)
        {
            for (int k = 0; k < maze[i].length; k++)
            {
                mazeString = mazeString + maze[i][k];
            }
            mazeString = mazeString + "\n";
        }

        return mazeString;
    }
}