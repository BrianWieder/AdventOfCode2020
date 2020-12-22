package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input-day2.txt");
        Scanner in = new Scanner(inputFile);
        int valid = 0;
        while(in.hasNextLine()) {
            String line = in.nextLine();
            int dash = line.indexOf("-");
            int space = line.indexOf(" ");
            int colon = line.indexOf(":");
            int min = Integer.parseInt(line.substring(0, dash));
            int max = Integer.parseInt(line.substring(dash + 1, space));
            char letter = line.substring(colon - 1, colon).charAt(0);
            String password = line.substring(colon + 1);
            int times = 0;
            for(char c : password.toCharArray()) {
                if(c == letter) {
                    times++;
                }
            }
            if(times >= min && times <= max) {
                valid++;
            }
        }
        System.out.println(valid);
    }
}
