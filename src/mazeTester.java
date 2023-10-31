public class mazeTester{
    public static void main(String[] args){
        maze test = new maze();
        System.out.println(test.loadMaze("maze-1"));
        square testsq = new square(0,0,0);
        System.out.println(test.getNeighbors(testsq));



    }
}