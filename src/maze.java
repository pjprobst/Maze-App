import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
public class maze
{
    private square[][] maze;
    private int numRows, numCols;
    private String fileName;

    public maze(){

    }

    public boolean loadMaze(String fname)
    {
        fileName = "C:\\Users\\pjprobst\\Desktop\\SOFTWARE REPOS\\MAZE PROGRAM\\Maze-App\\src\\" + fname;
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
                numRows = scanner.nextInt();
                numCols = scanner.nextInt();

                this.maze = new square[numRows][numCols];

            for (int row=0; row < numRows; row++) {
                for (int col=0; col < numCols; col++) {
                    maze[row][col] = new square(row, col, scanner.nextInt());
                }
            }
            return true;
        }

        catch (Exception e){
            System.out.println("FILE NOT FOUND");
            return false;
        }
    }
    public ArrayList<square> getNeighbors(square sq){
        ArrayList<square> neighbors = new ArrayList<square>();

        square north = maze[sq.getRow()-1][sq.getCol()];
        square east = maze[sq.getRow()][sq.getCol()+1];
        square south = maze[sq.getRow()+1][sq.getCol()];
        square west = maze[sq.getRow()][sq.getCol()-1];
        
        if (north != null){
            neighbors.add(north);
        }
        if (east != null){
            neighbors.add(east);
        }
        if (south != null){
            neighbors.add(south);
        }
        if (west != null){
            neighbors.add(west);
        }

        return neighbors;


    }
    square getStart(){
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {
                if (maze[row][col].getType() == 2){
                    return maze[row][col];
                }
            }
        }
        return null;
    }
    square getFinish(){
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {
                if (maze[row][col].getType() == 3){
                    return maze[row][col];
                }
            }
        }
        return null;
    }
    void reset(){
        loadMaze(fileName);
    }
    public String toString(){
        String strmaze = "";
        for (int row=0; row < numRows; row++) {
            for (int col=0; col < numCols; col++) {
                strmaze += (maze[row][col].toString()).substring(0, 1);
            }
            strmaze += "\n";
        }
        return strmaze;
    }
}