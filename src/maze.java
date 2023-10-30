import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
public class maze
{
    private square[][] maze;

    public maze(){

    }

    boolean loadMaze(String fname)
    {
        String fileName = "C:\\Users\\pjprobst\\Desktop\\SOFTWARE REPOS\\MAZE PROGRAM\\Maze-App\\src\\" + fname;
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            int numCols, numRows;
                numRows = scanner.nextInt();
                numCols = scanner.nextInt();

                this.maze = new square[numRows][numCols];

            for (int row=0; row < numRows; row++) {
                for (int col=0; col < numCols; col++) {
                    maze[row][col] = null;
                }
            }
            return true;
        }

        catch (Exception e){
            System.out.println("FILE NOT FOUND");
            return false;
        }
    }
    ArrayList<square> getNeighbors(square sq){
        Arraylist neighbors = new ArrayList();
        
        for()
    }
    /*
    Square getStart(){

    }
    Square getFinish(){

    }
    void reset(){

    }
    String toString(){

    }
    */
}