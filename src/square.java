import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class square{
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    File file = new File("maze-1.file");

    for (int i = 0; i < file.length(); i++){
        System.out.println(file.getName());
    }



}
}