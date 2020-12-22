package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part2 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input-day2.txt");
        Scanner in = new Scanner(inputFile);
        int valid = 0;
        while(in.hasNextLine()) {
            String line = in.nextLine();
            int dash = line.indexOf("-");
            int space = line.indexOf(" ");
            int colon = line.indexOf(":");
            int pos1 = Integer.parseInt(line.substring(0, dash)) - 1;
            int pos2 = Integer.parseInt(line.substring(dash + 1, space)) - 1;
            char letter = line.substring(colon - 1, colon).charAt(0);
            String password = line.substring(colon + 2);
            if((password.charAt(pos1) == letter || password.charAt(pos2) == letter) && password.charAt(pos1) != password.charAt(pos2)) {
                valid++;
            }
        }
        in.close();
        System.out.println(valid);
    }
}
