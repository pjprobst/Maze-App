public class mazeTester{
    public static void main(String[] args){
        maze test = new maze();
        System.out.println(test.loadMaze("maze-2"));
        square testsq = new square(0,1, test.getSquare(0, 1).getType());
        System.out.println(test.getNeighbors(testsq));
        System.out.println(test.getStart().getRow() + ", " + test.getStart().getCol());
        System.out.println(test.getFinish().getRow() + ", " + test.getFinish().getCol());
        System.out.println(test);
    }
}