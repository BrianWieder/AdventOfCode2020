package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input-day3.txt");
        Scanner in = new Scanner(inputFile);
        int index = 3;
        int rocks = 0;
        in.nextLine();
        while(in.hasNextLine()) {
            String line = in.nextLine();
            if(line.charAt(index) == '#') {
                rocks++;
            }
            index += 3;
            index = index % line.length();
        }
        System.out.println(rocks);

        in.close();
    }
}
